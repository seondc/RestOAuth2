package com.icarus.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.icarus.rest.handler.RestOAut2AccessDniedHandler;
import com.icarus.rest.handler.RestOAuth2AuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	private static final String RESOUCE_ID = "rest-api";
	
	@Autowired
	private RestOAut2AccessDniedHandler restOAut2AccessDniedHandler;
	
	@Autowired
	private RestOAuth2AuthenticationEntryPoint restOAuth2AuthenticationEntryPoint;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOUCE_ID);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/admin/**").permitAll().anyRequest().authenticated()
		.and().exceptionHandling().accessDeniedHandler(restOAut2AccessDniedHandler).authenticationEntryPoint(restOAuth2AuthenticationEntryPoint);
	}
}
