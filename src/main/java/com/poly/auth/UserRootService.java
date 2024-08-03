package com.poly.auth;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRootService implements UserDetailsService {
	private final AccountDao userRepo;

	public UserRootService(AccountDao userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return null;
	}

//  public UserDetails loadUserByUsername(String email)
//      throws UsernameNotFoundException {
//    Account user = userRepo.findByEmail(email)
//        .orElseThrow(() ->
//            new UsernameNotFoundException("User not found with email : " + email)
//        );
//
//    return UserRoot.create(user);
//  }
}
