package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysUserToken;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:27
 * @desc SysUserTokenMapper
 */
@Component
public interface SysUserTokenMapper {

    /**
     * 根据主键查询
     *
     * @param userId
     * @return
     */
    SysUserToken selectByPrimaryKey(Long userId);
}