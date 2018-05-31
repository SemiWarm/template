package cn.sprivacy.template.datasources.annotation;

import java.lang.annotation.*;

/**
 * @author fanglang
 * @date 2018-05-29 16:19
 * @desc 数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
