package com.naviworks.starxr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.naviworks.starxr.interceptor.AccountInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public AccountInterceptor accountInterceptor() {
		return new AccountInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accountInterceptor())
				.addPathPatterns("/account/modify");
	}

}