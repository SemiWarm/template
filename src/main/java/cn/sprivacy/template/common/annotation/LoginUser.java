package cn.sprivacy.template.common.annotation;

import java.lang.annotation.*;

/**
 * @author fanglang
 * @date 2018-06-01 14:57
 * @desc 已登录用户注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {
}
