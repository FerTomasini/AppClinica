package com.example.appclinica.response;

import java.util.List;

public class AuthResponse {

	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private final List<String> tipos;

	public AuthResponse(String accessToken, Long id, String username, List<String> tipos) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.tipos = tipos;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getTipos() {
		return tipos;
	}

}

