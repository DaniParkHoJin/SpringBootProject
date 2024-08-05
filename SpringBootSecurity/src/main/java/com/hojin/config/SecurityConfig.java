package com.hojin.config;

import com.hojin.common.security.CustomAccessDeniedHandler;
import com.hojin.common.security.CustomLoginSuccessHandler;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security configuring...");
        // URI 패턴으로 접근 제한을 설정한다.
        http.authorizeRequests()
                .antMatchers("/board/list")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/board/register")
                .hasRole("MEMBER");
        http.authorizeRequests()
                .antMatchers("/notice/list")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/notice/register")
                .hasRole("ADMIN");

        // 개발자가 정의한 로그인 페이지의 URI를 지정한다.
        // 로그인   성공    후   처리를   담당하는   처리자로   지정한다.
        http.formLogin()
                .loginPage("/login")
                .successHandler(createAuthenticationSuccessHandler());

        // 폼 기반 인증 기능을 사용한다.
        //  http.formLogin();

        // 로그아웃   처리를   위한   URI를   지정하고, 로그아웃한   후에   세션을   무효화   한다.
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

        // 등록한   CustomAccessDeniedHandler를   접근   거부    처리자로   지정한다.
        http.exceptionHandling()
                .accessDeniedHandler(createAccessDeniedHandler());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 지정된   아이디와   패스워드로   로그인이   가능하도록   설정한다.
        auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");

        auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");

    }

    // CustomAccessDeniedHandler를 빈으로 등록한다.
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomLoginSuccessHandler를   빈으로   등록한다.
    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
}
