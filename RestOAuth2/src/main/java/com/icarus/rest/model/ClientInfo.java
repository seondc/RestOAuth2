package com.icarus.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oauth_client_details")
public class ClientInfo {
	@Id
	@Column(name="client_id")
	private String clientId;
	@Column(name="resource_ids")
	private String resourceIds;
	@Column(name="client_secret")
	private String clientSecrt;
	@Column(name="scope")
	private String scope;
	@Column(name="authorized_grant_types")
	private String grantTypes;
	@Column(name="web_server_redirect_uri")
	private String redirectUri;
	@Column(name="authorities")
	private String authorities;
	@Column(name="access_token_validity")
	private int acessTokenValidity;
	@Column(name="refresh_token_validity")
	private int refreshTokenValidiry;
	@Column(name="additional_information")
	private String additionalInformation;
	@Column(name="autoapprove")
	private String autoapprove;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	public String getClientSecrt() {
		return clientSecrt;
	}
	public void setClientSecrt(String clientSecrt) {
		this.clientSecrt = clientSecrt;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getGrantTypes() {
		return grantTypes;
	}
	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public int getAcessTokenValidity() {
		return acessTokenValidity;
	}
	public void setAcessTokenValidity(int acessTokenValidity) {
		this.acessTokenValidity = acessTokenValidity;
	}
	public int getRefreshTokenValidiry() {
		return refreshTokenValidiry;
	}
	public void setRefreshTokenValidiry(int refreshTokenValidiry) {
		this.refreshTokenValidiry = refreshTokenValidiry;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public String getAutoapprove() {
		return autoapprove;
	}
	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}
}
