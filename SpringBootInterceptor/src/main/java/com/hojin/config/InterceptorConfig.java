package com.hojin.config;

import com.hojin.common.AccessLoggingInterceptor;
import com.hojin.common.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 원하는 URI에 적절한 패턴을 적용하여 인터셉터를 지정한다.
        // 원하는 URI에 적절한 패턴을 적용하여 인터셉터를 지정한다.
        // 여러 개의 인터셉터를 지정한다.

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");

        registry.addInterceptor(new AccessLoggingInterceptor()).addPathPatterns("/**").excludePathPatterns("/resources/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }



}
