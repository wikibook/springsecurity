/**
 * 
 */
package com.packtpub.springsecurity.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.packtpub.springsecurity.security.CustomJdbcDaoImpl;
import com.packtpub.springsecurity.security.IChangePassword;

/**
 * Implements methods declared in the IUserService interface.
 * 
 * @author Mularien
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	CustomJdbcDaoImpl jdbcDao;
	
	public void changePassword(String username, String password) {
		jdbcDao.changePassword(username, password);
	}

	@Override
	public void createUser(String username, String password, String email) {
		/* Alternative if you were using JdbcUserDetailsManager-based createUser
		GrantedAuthority roleUser = new GrantedAuthorityImpl("ROLE_USER");
		UserDetails user = new User(username, password, true, true, true, true, Arrays.asList(roleUser));
		jdbcDao.createUser(user);
		*/
		jdbcDao.createUser(username, password, email);
	}
	
	
}
