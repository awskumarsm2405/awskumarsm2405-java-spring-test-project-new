package com.skm.account.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CustomerDto {
	 private long customerId;
	 
	 @NotEmpty(message="password is rquired")
	 private String password;
	 private String mobileNumber;
	 
	 @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
	 private String name;
	 private String email;
	 private AccountDto accountdto;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AccountDto getAccountdto() {
		return accountdto;
	}
	public void setAccountdto(AccountDto accountdto) {
		this.accountdto = accountdto;
	}
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDto(long customerId, String password, String mobileNumber, String name, String email,
			AccountDto accountdto) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.email = email;
		this.accountdto = accountdto;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", name=" + name + ", email=" + email + ", accountdto=" + accountdto + "]";
	}
    
}
