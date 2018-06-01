package cn.sprivacy.template.common.resolver;

import cn.sprivacy.template.common.annotation.LoginUser;
import cn.sprivacy.template.common.interceptor.TokenInterceptor;
import cn.sprivacy.template.modules.sys.jpa.SysUserJpa;
import cn.sprivacy.template.modules.sys.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author fanglang
 * @date 2018-06-01 14:59
 * @desc LoginUserHandlerMethodArgumentResolver
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private SysUserJpa sysUserJpa;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(SysUser.class) && methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        // 获取用户ID
        Object object = nativeWebRequest.getAttribute(TokenInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
        Long userId = (Long) object;
        if (userId != 0) {
            return sysUserJpa.getOne(userId);
        }
        return null;
    }
}
