package cn.sprivacy.template.modules.sys.mapper;

import cn.sprivacy.template.modules.sys.model.SysOss;
import org.springframework.stereotype.Component;

/**
 * @author fanglang
 * @date 2018/5/31 10:26
 * @desc SysOssMapper
 */
@Component
public interface SysOssMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysOss selectByPrimaryKey(Long id);
}