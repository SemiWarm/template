package cn.sprivacy.template.modules.job.jpa;

import cn.sprivacy.template.modules.job.model.ScheduleJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:38
 * @desc ScheduleJobJpa
 */
public interface ScheduleJobJpa extends
        Serializable,
        JpaRepository<ScheduleJob, Long>,
        JpaSpecificationExecutor<ScheduleJob> {
}
