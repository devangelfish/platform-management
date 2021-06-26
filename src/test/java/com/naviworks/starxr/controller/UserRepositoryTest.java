package com.naviworks.starxr.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.naviworks.starxr.config.AppConfig;
import com.naviworks.starxr.config.WebConfig;
import com.naviworks.starxr.repository.UserRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void findTest() {
		assertNotNull(userRepository.find("1234"));
	}
}
