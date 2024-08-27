package com.skm.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.skm.account.entity.BaseEntity;


@Entity(name = "accounts")
public class Account extends BaseEntity {
	@Id
	@Column(name="account_id")
	private long accountId;
	
	@Column(name="customer_id")
	private long customerId;
	
	
	private String account_type;
	
	private String account_branch;
  
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long accountId, long customerId, String account_type, String account_branch) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.account_type = account_type;
		this.account_branch = account_branch;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", account_type=" + account_type
				+ ", account_branch=" + account_branch + "]";
	}
	
	
       
}
