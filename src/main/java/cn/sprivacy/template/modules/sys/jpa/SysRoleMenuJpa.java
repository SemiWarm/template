package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:43
 * @desc SysRoleMenuJpa
 */
public interface SysRoleMenuJpa extends
        Serializable,
        JpaRepository<SysRoleMenu, Long>,
        JpaSpecificationExecutor<SysRoleMenu> {
}
