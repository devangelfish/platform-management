package com.naviworks.starxr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.AccountRepository;
import com.naviworks.starxr.repository.UserRepository;
import com.naviworks.starxr.vo.UserVo;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public UserVo modify(UserVo userVo) {
		accountRepository.modify(userVo);
		
		return userRepository.find(userVo.getId());
	}
}
