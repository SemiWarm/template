package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysConfig;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:25
 * @desc SysConfigMapper
 */
@Component
public interface SysConfigMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysConfig selectByPrimaryKey(Long id);
}