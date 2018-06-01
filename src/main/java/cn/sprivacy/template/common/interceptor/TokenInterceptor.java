package cn.sprivacy.template.common.interceptor;

import cn.sprivacy.template.common.exception.TmpException;
import cn.sprivacy.template.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fanglang
 * @date 2018-06-01 14:05
 * @desc Token验证
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(jwtUtils.getHeader());
        }

        // 凭证为空
        if (StringUtils.isBlank(token)) {
            throw new TmpException(HttpStatus.UNAUTHORIZED.value(), jwtUtils.getHeader() + "不能为空");
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if (null == claims || jwtUtils.isTokenExpired(claims.getExpiration())) {
            throw new TmpException(HttpStatus.UNAUTHORIZED.value(), jwtUtils.getHeader() + "已失效,请重新登录");
        }

        // 设置userId到request里,后续根据userId,获取用户信息
        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

        return true;
    }
}
