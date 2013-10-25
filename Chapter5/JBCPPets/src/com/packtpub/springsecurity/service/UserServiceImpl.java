/**
 * 
 */
package com.packtpub.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packtpub.springsecurity.security.IChangePassword;

/**
 * Implements methods declared in the IUserService interface.
 * 
 * @author Mularien
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IChangePassword changePasswordDao;
	
	public void changePassword(String username, String password) {
		changePasswordDao.changePassword(username, password);
	}
}
