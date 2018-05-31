package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysRoleMenu;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:26
 * @desc SysRoleMenuMapper
 */
@Component
public interface SysRoleMenuMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysRoleMenu selectByPrimaryKey(Long id);
}