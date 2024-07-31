package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;


public interface AccountDao extends JpaRepository<Account, Integer> {
	 List<Account> findByUserName(String userName);
//	  @Query ("SELECT o FROM Account o WHERE o.accountID LIKE ?1")
//	  List<Account> findByIdd(Integer accountID);
	 
	 Account findByAccountID(int accountID);
}
