package cn.sprivacy.template.common.annotation;

import java.lang.annotation.*;

/**
 * @author fanglang
 * @date 2018-05-30 16:02
 * @desc 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
