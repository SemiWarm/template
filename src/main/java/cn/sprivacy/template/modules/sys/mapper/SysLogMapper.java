package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysLog;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:25
 * @desc SysLogMapper
 */
@Component
public interface SysLogMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysLog selectByPrimaryKey(Long id);
}