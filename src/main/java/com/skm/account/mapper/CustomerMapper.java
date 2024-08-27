package com.skm.account.mapper;

import com.skm.account.dto.CustomerDto;
import com.skm.account.entity.Customer;

public class CustomerMapper {
              public static Customer mapCustomerDtoToCustomer(CustomerDto customerDto, Customer customer){
            	  customer.setEmail(customerDto.getEmail());
            	  customer.setMobileNumber(customerDto.getMobileNumber());
            	  customer.setName(customerDto.getName());
            	  customer.setPassword(customerDto.getPassword());
            	  return customer;
              }
}
