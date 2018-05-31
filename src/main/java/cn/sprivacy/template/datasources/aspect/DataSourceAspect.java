package cn.sprivacy.template.datasources.aspect;

import cn.sprivacy.template.datasources.DataSourceNames;
import cn.sprivacy.template.datasources.DynamicDataSource;
import cn.sprivacy.template.datasources.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author fanglang
 * @date 2018-05-29 16:21
 * @desc 多数据源切面处理类
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(cn.sprivacy.template.datasources.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            LOGGER.debug("Set datasource is:" + DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            LOGGER.debug("Set datasource is:" + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            LOGGER.debug("Clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
