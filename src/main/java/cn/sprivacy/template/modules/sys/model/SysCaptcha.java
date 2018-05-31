package cn.sprivacy.template.modules.sys.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author fanglang
 * @date 2018/5/31 10:31
 * @desc SysCaptcha
 */
@Entity
@Table(name = "sys_captcha")
public class SysCaptcha {

    @Id
    private String uuid;

    private String code;

    private Date expireTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}