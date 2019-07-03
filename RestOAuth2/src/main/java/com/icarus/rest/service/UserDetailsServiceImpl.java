package com.icarus.rest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icarus.rest.model.UserInfo;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserInfo userInfo = userInfoService.getUserInfoByUsername(username);
		if(userInfo == null) {
			throw new UsernameNotFoundException("Not Found user["+username+"]");
		} else {
			GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
			return new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));
		}
	}
}
