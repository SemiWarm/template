package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysUser;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:26
 * @desc SysUserMapper
 */
@Component
public interface SysUserMapper {

    /**
     * 根据主键查询
     *
     * @param userId
     * @return
     */
    SysUser selectByPrimaryKey(Long userId);
}