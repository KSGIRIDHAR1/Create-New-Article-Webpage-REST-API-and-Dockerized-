package com.cts.newsarticle.bean;

public class AuthenticationStatus {
	private boolean authenticated;
	private boolean isAdmin;
	private String token;
	private User user; 


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AuthenticationStatus(boolean authenticated) {
		super();
		this.authenticated = authenticated;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}	
	
	
	
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationStatus(boolean authenticated, boolean isAdmin, String token, User user) {
		super();
		this.authenticated = authenticated;
		this.isAdmin = isAdmin;
		this.token = token;
		this.user = user;
	}

	

	

}
