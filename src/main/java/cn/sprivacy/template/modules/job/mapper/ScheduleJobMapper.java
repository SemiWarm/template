package cn.sprivacy.template.modules.job.mapper;

import cn.sprivacy.template.modules.job.model.ScheduleJob;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    /**
     * 批量更新
     *
     * @param map
     * @return
     */
    int updateInBatch(Map<String, Object> map);
}