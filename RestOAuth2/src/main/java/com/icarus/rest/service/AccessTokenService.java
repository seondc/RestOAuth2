package com.icarus.rest.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService {
	@Autowired
	private AuthorizationServerEndpointsConfiguration configuration;
	
	@Autowired
	private TokenEndpoint tokenEndpoint;
	
	public OAuth2AccessToken createAccessToken() {
		Map<String,Serializable> extensitionProperties = new HashMap<String,Serializable>();
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		Set<String> scopes = new HashSet<String>();
		scopes.add("read");
		
		Set<String> resourceIds = new HashSet<String>();
		resourceIds.add("resource-server-rest-api");
		
		Set<String> responseTypes = new HashSet<String>();
		resourceIds.add("client_credentials");
		
		OAuth2Request oAuth2Request = new OAuth2Request(Collections.emptyMap(),"client",authorities,true,scopes,resourceIds,"",responseTypes,extensitionProperties);
		UsernamePasswordAuthenticationToken userAuthentication = new  UsernamePasswordAuthenticationToken("admin",null,authorities);
		OAuth2Authentication authentication = new OAuth2Authentication(oAuth2Request, userAuthentication);
		AuthorizationServerTokenServices tokenServices = configuration.getEndpointsConfigurer().getTokenServices();
		return tokenServices.createAccessToken(authentication);
	}
	
	public OAuth2AccessToken refreshAccessToken(String refreshToken) {
		Map<String,String> requestParameters = new HashMap<String,String>();
		requestParameters.put("username","admin");
		
		Set<String> scope = new HashSet<String>();
		scope.add("read");
		
		TokenRequest tokenRequest = new TokenRequest(requestParameters, "client", scope, "refresh_token");
		AuthorizationServerTokenServices tokenServices = configuration.getEndpointsConfigurer().getTokenServices();
		return tokenServices.refreshAccessToken(refreshToken, tokenRequest);
	}
	
	public OAuth2AccessToken createAccessToken2() throws Exception {
		Map<String,String> requestParameters = new HashMap<String,String>();
		requestParameters.put("client_id","client");
		requestParameters.put("client_secret","1234");
		requestParameters.put("grant_type","client_credentials");
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		User user = new User("client","1234",true,true,true,true,authorities);
		UsernamePasswordAuthenticationToken principal = new  UsernamePasswordAuthenticationToken(user,"1234",authorities);
		ResponseEntity<OAuth2AccessToken> response = tokenEndpoint.postAccessToken(principal, requestParameters);
		return response.getBody();
	}
}
