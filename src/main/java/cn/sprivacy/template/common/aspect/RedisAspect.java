package cn.sprivacy.template.common.aspect;

import cn.sprivacy.template.common.exception.TmpException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanglang
 * @date 2018/6/2 上午10:30
 * @desc RedisAspect Redis服务切面类
 */
@Aspect
@Configuration
public class RedisAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisAspect.class);

    /**
     * 是否开启redis缓存,true开启,false关闭
     */
    @Value("${spring.redis.open: false}")
    private boolean open;

    @Around("execution(* cn.sprivacy.template.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = point.proceed();
            } catch (Exception e) {
                LOGGER.error("Redis error:", e);
                throw new TmpException(500, "Redis服务异常");
            }
        }
        return result;
    }
}
