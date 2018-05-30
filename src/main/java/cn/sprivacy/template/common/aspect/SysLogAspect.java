package cn.sprivacy.template.common.aspect;

import cn.sprivacy.template.common.annotation.Log;
import cn.sprivacy.template.common.utils.DateUtils;
import cn.sprivacy.template.common.utils.HttpContextUtils;
import cn.sprivacy.template.common.utils.IpUtils;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author fanglang
 * @date 2018-05-30 16:04
 * @desc 系统日志切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysLogAspect.class);

    @Pointcut("@annotation(cn.sprivacy.template.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveSysLog(point, time);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long dateTime) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Log log = method.getAnnotation(Log.class);
        if(log != null){
            // 注解上的描述
            LOGGER.info("Operation:" + log.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        LOGGER.info("Method:" + className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        LOGGER.info("Params:" + params);

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        LOGGER.info("IpAddr:" + IpUtils.getIpAddr(request));

        // 日期
        LOGGER.info("DateTime:" + DateUtils.getFromatTime(new Date(dateTime)));
    }
}
