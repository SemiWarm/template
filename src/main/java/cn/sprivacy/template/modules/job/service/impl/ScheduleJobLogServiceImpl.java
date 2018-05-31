package cn.sprivacy.template.modules.job.service.impl;

import cn.sprivacy.template.modules.job.jpa.ScheduleJobLogJpa;
import cn.sprivacy.template.modules.job.model.ScheduleJobLog;
import cn.sprivacy.template.modules.job.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanglang
 * @date 2018-05-31 15:32
 * @desc ScheduleJobLogServiceImpl
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Autowired
    private ScheduleJobLogJpa scheduleJobLogJpa;

    @Override
    public ScheduleJobLog insert(ScheduleJobLog scheduleJobLog) {
        return scheduleJobLogJpa.save(scheduleJobLog);
    }
}
