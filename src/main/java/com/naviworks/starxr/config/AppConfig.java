package com.naviworks.starxr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.naviworks.starxr.app.DBConfig;
import com.naviworks.starxr.app.MyBatisConfig;
import com.naviworks.starxr.app.SecurityConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.naviworks.starxr.service",
				"com.naviworks.starxr.repository",
				"com.naviworks.starxr.aspect",
				"com.naviworks.starxr.security"})
@Import({DBConfig.class, MyBatisConfig.class, SecurityConfig.class})
public class AppConfig {
}