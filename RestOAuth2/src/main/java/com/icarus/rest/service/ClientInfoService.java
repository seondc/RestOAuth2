package com.icarus.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.icarus.rest.model.ClientInfo;
import com.icarus.rest.repository.ClientInfoRepository;

@Service
@Transactional
public class ClientInfoService {
	@Autowired
	private ClientInfoRepository clientInfoRepository;
	public ClientInfo addClient(ClientInfo clientInfo) {
		clientInfo.setClientSecrt(new BCryptPasswordEncoder().encode(clientInfo.getClientSecrt()));
		return clientInfoRepository.save(clientInfo);
	}
}
