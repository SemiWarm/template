package cn.sprivacy.template.modules.sys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fanglang
 * @date 2018/5/31 10:36
 * @desc SysUserRole
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}