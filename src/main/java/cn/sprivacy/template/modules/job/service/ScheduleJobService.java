package cn.sprivacy.template.modules.job.service;

import cn.sprivacy.template.modules.job.model.ScheduleJob;

/**
 * @author fanglang
 * @date 2018-05-31 15:45
 * @desc ScheduleJobService
 */
public interface ScheduleJobService {

    /**
     * 保存定时任务
     *
     * @param scheduleJob
     */
    void save(ScheduleJob scheduleJob);


    /**
     * 更新定时任务
     *
     * @param scheduleJob
     */
    void update(ScheduleJob scheduleJob);


    /**
     * 批量删除定时任务
     *
     * @param jobIds
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     *
     * @param jobIds
     * @param status
     * @return
     */
    int updateBatch(Long[] jobIds, int status);

    /**
     * 立即执行
     *
     * @param jobIds
     */
    void run(Long[] jobIds);


    /**
     * 暂停运行
     *
     * @param jobIds
     */
    void pause(Long[] jobIds);


    /**
     * 恢复运行
     *
     * @param jobIds
     */
    void resume(Long[] jobIds);
}
