package com.naviworks.starxr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.naviworks.starxr.web.InterceptorConfig;
import com.naviworks.starxr.web.MailConfig;
import com.naviworks.starxr.web.MessageSourceConfig;
import com.naviworks.starxr.web.MvcConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.naviworks.starxr.controller",
				"com.naviworks.starxr.exception",
				"com.naviworks.starxr.service"})
@Import({MvcConfig.class, MessageSourceConfig.class, InterceptorConfig.class, MailConfig.class})
public class WebConfig {

}
