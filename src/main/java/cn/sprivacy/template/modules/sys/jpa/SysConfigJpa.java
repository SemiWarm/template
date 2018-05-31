package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.SysConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:41
 * @desc SysConfigJpa
 */
public interface SysConfigJpa extends
        Serializable,
        JpaRepository<SysConfig, Long>,
        JpaSpecificationExecutor<SysConfig> {
}
