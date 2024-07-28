package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.entity.Account;


public interface AccountDao extends JpaRepository<Account, Integer> {
	 List<Account> findByUserName(String userName);
}
