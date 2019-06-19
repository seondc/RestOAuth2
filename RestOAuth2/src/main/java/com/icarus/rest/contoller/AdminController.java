package com.icarus.rest.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.rest.model.ClientInfo;
import com.icarus.rest.service.ClientInfoService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ClientInfoService clientInfoService;
	
	@RequestMapping("/add")
	public ResponseEntity<ClientInfo> add(@RequestParam String clientid, @RequestParam String secret) {
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setClientId(clientid);
		clientInfo.setClientSecrt(secret);
		clientInfo.setGrantTypes("authorization_code,password,client_credentials,refresh_token");
		clientInfo.setAcessTokenValidity(3000);
		clientInfo.setRefreshTokenValidiry(6000);
		clientInfo.setAuthorities("ADMIN");
		clientInfo = clientInfoService.addClient(clientInfo);
		return new ResponseEntity<ClientInfo>(clientInfo, HttpStatus.OK);
	}
	
	@RequestMapping("/get")
	public ResponseEntity<ClientInfo> add(@RequestParam String clientid) {
		ClientInfo clientInfo = clientInfoService.getClient(clientid);
		return new ResponseEntity<ClientInfo>(clientInfo, HttpStatus.OK);
	}
}
