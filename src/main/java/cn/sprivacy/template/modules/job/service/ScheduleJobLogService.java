package cn.sprivacy.template.modules.job.service;

import cn.sprivacy.template.modules.job.model.ScheduleJobLog;

/**
 * @author fanglang
 * @date 2018-05-31 15:22
 * @desc ScheduleJobLogService
 */
public interface ScheduleJobLogService {

    /**
     * 插入ScheduleJobLog
     *
     * @param scheduleJobLog
     * @return
     */
    ScheduleJobLog insert(ScheduleJobLog scheduleJobLog);
}
