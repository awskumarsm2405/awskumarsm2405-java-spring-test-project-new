package com.skm.account.dto;

import jakarta.validation.constraints.Size;

public class LoginRequest {
    
	@Size(min=4, max=15, message="min and max size should be 4 and 15")
	private String name;
    private String password;
    public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	    
}
