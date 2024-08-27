package com.skm.account.dto;

import jakarta.persistence.Column;
import lombok.Data;


public class AccountDto {
	private long customerId;
    private long accountId;
	private String account_type;
	private String account_branch;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_branch() {
		return account_branch;
	}
	public void setAccount_branch(String account_branch) {
		this.account_branch = account_branch;
	}
}
