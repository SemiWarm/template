package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysCaptcha;

/**
 * @author fanglang
 * @date 2018/5/31 10:24
 * @desc SysCaptchaMapper
 */
public interface SysCaptchaMapper {

    /**
     * 根据主键查询
     *
     * @param uuid
     * @return
     */
    SysCaptcha selectByPrimaryKey(String uuid);
}