package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysUserRole;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:27
 * @desc SysUserRoleMapper
 */
@Component
public interface SysUserRoleMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysUserRole selectByPrimaryKey(Long id);
}