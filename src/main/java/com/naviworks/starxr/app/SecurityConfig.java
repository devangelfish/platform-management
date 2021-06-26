package com.naviworks.starxr.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.naviworks.starxr.security.CommonUserHandler;
import com.naviworks.starxr.security.CustomLoginFailuerHandler;
import com.naviworks.starxr.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// super.configure(web); // 아무런 작업을 하지 않음
		web.ignoring().antMatchers("/assets/**", "/favicon.ico");
		// 스프링 시큐리티의 필터 연결을 설정하기 위한 오버라이딩이다.
		// 예외가 웹접근 URL를 설정한다.
		// ACL(Access Control List - 접근 제어 목록)의 예외 URL을 설정
	}
		
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean 
	public CommonUserHandler commonUserHandler() {
		return new CommonUserHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler FailuerHandler() {
		return new CustomLoginFailuerHandler();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
		
		http
			.csrf().disable();
		
		http
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/auth")
			.usernameParameter("id")
			.passwordParameter("password")
			.successHandler(successHandler())
			.failureHandler(FailuerHandler());			
		
		http
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		
		http
			.sessionManagement()
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}
