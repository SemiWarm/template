package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.ScheduleJobLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:40
 * @desc ScheduleJobLogJpa
 */
public interface ScheduleJobLogJpa extends
        Serializable,
        JpaRepository<ScheduleJobLog, Long>,
        JpaSpecificationExecutor<ScheduleJobLog> {
}
