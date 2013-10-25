package com.packtpub.springsecurity.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	/**
	 * Gets the current request's {@link Authentication} information and returns it.
	 *  
	 * @return Authentication for current request
	 */
	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();		
	}

	@ModelAttribute("showLoginLink")
	public boolean getShowLoginLink() {
		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
			if(authority.getAuthority().equals("ROLE_USER")) {
				return false;
			}	
		}
		return true;
	}
}
