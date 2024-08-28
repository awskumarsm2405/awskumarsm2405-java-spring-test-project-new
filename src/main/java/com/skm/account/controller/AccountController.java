package com.skm.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.skm.account.dto.CustomerDto;
import com.skm.account.dto.ErrorResponseDto;
import com.skm.account.services.IAccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
 
@RestController
@RequestMapping(path="/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(
        name = "CRUD REST APIs for Accounts in SKMBank",
        description = "CRUD REST APIs in SKMBank to CREATE, UPDATE, FETCH AND DELETE account details"
)
public class AccountController {
       
	   @Autowired
	   IAccountService accountService;
	   
       @PostMapping("/create")
       public CustomerDto createAccount(@Valid @RequestBody CustomerDto customerDto){
    	   return accountService.createAccount(customerDto);  
    	   //return customerDto;
       }
       @Operation(
               summary = "Fetch All Accouns REST API",
               description = "REST API to fetch all Customer &  Account details"
       )
       @ApiResponses({
               @ApiResponse(
                       responseCode = "200",
                       description = "HTTP Status OK"
               ),
               @ApiResponse(
                       responseCode = "500",
                       description = "HTTP Status Internal Server Error",
                       content = @Content(
                               schema = @Schema(implementation = ErrorResponseDto.class)
                       )
               )
       }
       )
       @SecurityRequirement(name = "Bearer Authentication")
       @GetMapping("/all")
       public List<CustomerDto> GetAccount(){
    	   return accountService.getAllAccount();  
    	   //return customerDto;
       }
       @GetMapping("/customer/{username}")
       public CustomerDto getCustomerByUsername(@Valid @PathVariable @Pattern(regexp="(^$|[0-9]{10})", message="it should be 10 digit only")  String username){
    	   return accountService.findByMobile(username);  
    	   //return customerDto;
       }
       @GetMapping("/customer")
       public CustomerDto getCustomerByMobile(@Valid @RequestParam @Pattern(regexp="(^$|[0-9]{10})", message="it should be 10 digit only") String mobilenumber){
    	   return accountService.findByMobile(mobilenumber);  
    	   //return customerDto;
       }

       @PutMapping("/customer/{mobilenumber}")
       public String updateCustomerByMobile(@Valid @PathVariable @Pattern(regexp="(^$|[0-9]{10})", message="it should be 10 digit only") String mobilenumber, @RequestBody CustomerDto customerDto){
    	   //return accountService.findByMobile(mobilenumber);  
    	   //return customerDto;
           return "Customer Update";
       }
       
       
}
