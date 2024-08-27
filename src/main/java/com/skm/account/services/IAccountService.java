package com.skm.account.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skm.account.dto.CustomerDto;
import com.skm.account.entity.Customer;

@Service
public interface IAccountService {
     CustomerDto createAccount(CustomerDto customerDto);

	List<CustomerDto> getAllAccount();

	CustomerDto findByMobile(String mobilenumber);
}
