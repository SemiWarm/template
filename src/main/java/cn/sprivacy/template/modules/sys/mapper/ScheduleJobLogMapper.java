package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.ScheduleJobLog;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:23
 * @desc ScheduleJobLogMapper
 */
@Component
public interface ScheduleJobLogMapper {

    /**
     * 根据主键查询
     *
     * @param logId
     * @return
     */
    ScheduleJobLog selectByPrimaryKey(Long logId);
}