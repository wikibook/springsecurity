package com.packtpub.springsecurity.service;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Provides functionality related to user management.
 *  
 * @author Mularien
 */
public interface IUserService {
	/**
	 * Changes the password for the given username. Expects that the calling user
	 * is a valid user of the system.
	 * 
	 * @param username the name of the user to change
	 * @param password the password to change to
	 */
	@PreAuthorize("#username == principal.username and hasRole('ROLE_ADMIN')")
	// Ch 05 JSR-250 test
//	@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
	public void changePassword(String username, String password);
}
