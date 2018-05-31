package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.ScheduleJob;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:24
 * @desc ScheduleJobMapper
 */
@Component
public interface ScheduleJobMapper {

    /**
     * 根据主键查询
     *
     * @param jobId
     * @return
     */
    ScheduleJob selectByPrimaryKey(Long jobId);
}