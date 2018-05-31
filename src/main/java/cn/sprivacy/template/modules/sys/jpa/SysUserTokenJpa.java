package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.SysUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:44
 * @desc SysUserTokenJpa
 */
public interface SysUserTokenJpa extends
        Serializable,
        JpaRepository<SysUserToken, Long>,
        JpaSpecificationExecutor<SysUserToken> {
}
