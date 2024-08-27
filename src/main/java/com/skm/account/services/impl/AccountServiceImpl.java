package com.skm.account.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skm.account.dto.AccountDto;
import com.skm.account.dto.CustomerDto;
import com.skm.account.entity.Account;
import com.skm.account.entity.Customer;
import com.skm.account.mapper.CustomerMapper;
import com.skm.account.repository.AccountRepository;
import com.skm.account.repository.CustomerRepository;
import com.skm.account.services.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
    
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public CustomerDto createAccount(CustomerDto customerDto) {
		Customer customerData = CustomerMapper.mapCustomerDtoToCustomer(customerDto, new Customer());
		customerData.setPassword(passwordEncoder.encode(customerData.getPassword()));

		Customer customer =  customerRepository.save(customerData);
		customerDto.setCustomerId(customer.getCustomerId());
		String accoutType = customerDto.getAccountdto().getAccount_type();
		String accoutBranch = customerDto.getAccountdto().getAccount_branch();
		Account account = accountRepository.save(createNewAccount(customer, accoutType, accoutBranch));
		AccountDto accountdto = customerDto.getAccountdto();
		accountdto.setAccountId(account.getAccountId());
		accountdto.setCustomerId(account.getCustomerId());
		customerDto.setAccountdto(accountdto);
		return customerDto;
	}

	private Account createNewAccount(Customer customer, String accoutType, String accoutBranch) {
		Account account = new Account();
		account.setCustomerId(customer.getCustomerId());
		long randomAccNumber = new Random().nextInt(1000);
		account.setAccountId(randomAccNumber);
		account.setAccount_type(accoutType);
		account.setAccount_branch(accoutBranch);;
		return account;
	}

	@Override
	public List<CustomerDto> getAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto findByMobile(String mobilenumber) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
