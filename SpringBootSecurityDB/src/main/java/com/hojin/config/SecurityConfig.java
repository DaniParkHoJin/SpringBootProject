package com.hojin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.hojin.common.security.CustomAccessDeniedHandler;
import com.hojin.common.security.CustomLoginSuccessHandler;
import com.hojin.common.security.CustomUserDetailsService;

import lombok.extern.java.Log;
import security.CustomNoOpPasswordEncoder;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config ...");
		// URI 패턴으로 접근 제한을 설정한다.

		http.authorizeRequests().antMatchers("/board/list").permitAll();
		http.authorizeRequests().antMatchers("/board/register").hasRole("MEMBER");
		http.authorizeRequests().antMatchers("/notice/list").permitAll();
		http.authorizeRequests().antMatchers("/notice/register").hasRole("ADMIN");

		http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

		// 로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제해 주도록 한다.
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID");
		http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());

		// 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
		// 쿠키의 유효 시간을 지정한다(24시간)
		http.rememberMe().key("hojin").tokenRepository(createJDBCRepository()).tokenValiditySeconds(60*60*24);
		
	}

	private PersistentTokenRepository createJDBCRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		
		return repo;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// CustomUserDetailsService 빈을 인증 제공자에 지정한다.
		auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
	}

	// 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다.
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
}
