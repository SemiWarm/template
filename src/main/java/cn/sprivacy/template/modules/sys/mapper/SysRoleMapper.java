package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysRole;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:26
 * @desc SysRoleMapper
 */
@Component
public interface SysRoleMapper {

    /**
     * 根据主键查询
     *
     * @param roleId
     * @return
     */
    SysRole selectByPrimaryKey(Long roleId);
}