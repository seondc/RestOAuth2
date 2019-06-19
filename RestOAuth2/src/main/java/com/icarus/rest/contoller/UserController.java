package com.icarus.rest.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.rest.model.UserInfo;
import com.icarus.rest.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/add")
	public ResponseEntity<UserInfo> add(@RequestParam String username, @RequestParam String password) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setRole("ADMIN");
		userInfo.setEnabled(true);
		userInfo = userInfoService.addUser(userInfo);
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
	}
}
