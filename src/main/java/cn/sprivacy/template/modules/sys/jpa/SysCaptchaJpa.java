package cn.sprivacy.template.modules.sys.jpa;

import cn.sprivacy.template.modules.sys.model.SysCaptcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fanglang
 * @date 2018-05-31 10:41
 * @desc SysCaptchaJpa
 */
public interface SysCaptchaJpa extends
        Serializable,
        JpaRepository<SysCaptcha, String>,
        JpaSpecificationExecutor<SysCaptcha> {
}
