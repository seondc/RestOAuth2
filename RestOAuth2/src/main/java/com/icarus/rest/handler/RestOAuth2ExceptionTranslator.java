package com.icarus.rest.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import com.icarus.rest.exception.CustomOauthException;

@Component
public class RestOAuth2ExceptionTranslator extends DefaultWebResponseExceptionTranslator {
	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
        OAuth2Exception body = responseEntity.getBody();
        
        return ResponseEntity
                .status(body.getHttpErrorCode())
                .body(new CustomOauthException(body.getMessage()));
	}
}
