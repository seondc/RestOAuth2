package com.icarus.rest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.icarus.rest.model.UserInfo;
import com.icarus.rest.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo getUserInfoByUsername(String username) {
		return userInfoRepository.findByUsernameAndEnabled(username, true);
	}
	
	public List<UserInfo> getAllActiveUserInfo() {
		return userInfoRepository.findAllByEnabled(true);
	}
	
	public Optional<UserInfo> getUserInfoById(Long id) {
		return  userInfoRepository.findById(id);
	}
	
	public UserInfo addUser(UserInfo userInfo) {
		userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
		return userInfoRepository.save(userInfo);
	}
	
	public UserInfo updateUser(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}
	
	public void deleteUser(Long id) {
		userInfoRepository.deleteById(id);
	}
}
