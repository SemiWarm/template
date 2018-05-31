package cn.sprivacy.template.modules.job.utils;

import cn.sprivacy.template.common.utils.SpringContextUtils;
import cn.sprivacy.template.modules.job.model.ScheduleJob;
import cn.sprivacy.template.modules.job.model.ScheduleJobLog;
import cn.sprivacy.template.modules.job.service.ScheduleJobLogService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author fanglang
 * @date 2018-05-31 15:07
 * @desc 定时任务
 */
public class ScheduleJobBean extends QuartzJobBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleJobBean.class);

    /**
     * 手动创建线程池
     */
    private ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("tmp-service-pool-%d").build();
    private ExecutorService service = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), factory, new ThreadPoolExecutor.AbortPolicy());

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {

        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get(ScheduleJob.JOB_PARAM_KEY);
        // 获取spring bean
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");

        // 数据库保存执行记录
        ScheduleJobLog log = new ScheduleJobLog();
        log.setJobId(scheduleJob.getJobId());
        log.setBeanName(scheduleJob.getBeanName());
        log.setMethodName(scheduleJob.getMethodName());
        log.setParams(scheduleJob.getParams());
        log.setCreateAt(new Date());

        // 任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            // 执行任务
            LOGGER.info("任务准备执行,任务ID:" + scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(),
                    scheduleJob.getMethodName(), scheduleJob.getParams());
            Future<?> future = service.submit(task);
            future.get();
            // 任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);
            // 任务状态 0:成功    1:失败
            log.setStatus(0);

            LOGGER.info("任务执行完毕,任务ID:" + scheduleJob.getJobId() + "  总共耗时:" + times + "毫秒");
        } catch (Exception e) {
            LOGGER.error("任务执行失败,任务ID:" + scheduleJob.getJobId(), e);

            // 任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);

            // 任务状态 0:成功    1:失败
            log.setStatus(1);
            log.setError(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            scheduleJobLogService.insert(log);
        }
    }
}
