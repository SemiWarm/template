package cn.sprivacy.template.common.config;

import cn.sprivacy.template.common.interceptor.TokenInterceptor;
import cn.sprivacy.template.common.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author fanglang
 * @date 2018-06-01 14:51
 * @desc MVC配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/app/**")
                .addPathPatterns("/sys/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}
