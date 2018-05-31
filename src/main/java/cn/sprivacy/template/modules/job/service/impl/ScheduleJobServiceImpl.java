package cn.sprivacy.template.modules.job.service.impl;

import cn.sprivacy.template.common.utils.Constant;
import cn.sprivacy.template.modules.job.jpa.ScheduleJobJpa;
import cn.sprivacy.template.modules.job.mapper.ScheduleJobMapper;
import cn.sprivacy.template.modules.job.model.ScheduleJob;
import cn.sprivacy.template.modules.job.service.ScheduleJobService;
import cn.sprivacy.template.modules.job.utils.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanglang
 * @date 2018-05-31 15:46
 * @desc ScheduleJobServiceImpl
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleJobJpa scheduleJobJpa;

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    /**
     * 项目启动时初始化定时器
     */
    @PostConstruct
    public void init() {
        List<ScheduleJob> scheduleJobs = scheduleJobJpa.findAll();
        if (scheduleJobs.size() > 0) {
            for (ScheduleJob scheduleJob : scheduleJobs) {
                CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
                // 如果不存在,则创建
                if (cronTrigger == null) {
                    ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
                } else {
                    ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
                }
            }
        } else {
            LOGGER.info("没有需要初始化的定时器");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ScheduleJob scheduleJob) {
        scheduleJob.setCreateAt(new Date());
        scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
        scheduleJobJpa.save(scheduleJob);
        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ScheduleJob scheduleJob) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
        scheduleJobJpa.saveAndFlush(scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
            scheduleJobJpa.deleteById(jobId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBatch(Long[] jobIds, int status) {
        Map<String, Object> map = new HashMap<>();
        for (Long jobId : jobIds) {
            map.put("jobId", jobId);
            map.put("status", status);
        }
        return scheduleJobMapper.updateInBatch(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.run(scheduler, scheduleJobJpa.getOne(jobId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
        Map<String, Object> map = new HashMap<>();
        for (Long jobId : jobIds) {
            map.put("jobId", jobId);
            map.put("status", Constant.ScheduleStatus.PAUSE.getValue());
        }
        scheduleJobMapper.updateInBatch(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resume(Long[] jobIds) {
        Map<String, Object> map = new HashMap<>();
        for (Long jobId : jobIds) {
            map.put("jobId", jobId);
            map.put("status", Constant.ScheduleStatus.NORMAL.getValue());
        }
        scheduleJobMapper.updateInBatch(map);
    }
}
