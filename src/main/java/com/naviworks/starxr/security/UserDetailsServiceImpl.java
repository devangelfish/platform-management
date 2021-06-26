package com.naviworks.starxr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.UserRepository;
import com.naviworks.starxr.vo.UserVo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo userVo = userRepository.find(username);
		
		SecurityUser securityUser = new SecurityUser();
		
		if(userVo != null) {
			securityUser.setName(userVo.getName());
			securityUser.setUsername(userVo.getId());
			securityUser.setPassword(userVo.getPassword());
		}
		
		return securityUser;
	}

}
