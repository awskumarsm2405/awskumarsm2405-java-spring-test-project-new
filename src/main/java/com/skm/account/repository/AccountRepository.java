package com.skm.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skm.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
