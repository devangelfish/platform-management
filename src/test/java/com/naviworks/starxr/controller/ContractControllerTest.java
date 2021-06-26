package com.naviworks.starxr.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.naviworks.starxr.config.AppConfig;
import com.naviworks.starxr.config.WebConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
public class ContractControllerTest {
	@Autowired
	ContractController contractController;
	
	public void getContract() {
	}
}