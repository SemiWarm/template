package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:42
 * @desc SysMenuJpa
 */
public interface SysMenuJpa extends
        Serializable,
        JpaRepository<SysMenu, Long>,
        JpaSpecificationExecutor<SysMenu> {
}
