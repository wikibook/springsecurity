package com.packtpub.springsecurity.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	/**
	 * Sets a message to be displayed to the user.
	 * @param request the servlet request
	 * @param message the message to be displayed
	 */
	protected void setMessage(HttpServletRequest request, String message) {
		request.getSession(true).setAttribute("GLOBAL_MESSAGE", message);
	}
	
	/**
	 * Gets the global message for display.
	 * 
	 * @param request the servlet request
	 * @return the message for display
	 */
	@ModelAttribute("globalMessage")
	public String getMessage(HttpServletRequest request) {
		final String message = (String) request.getSession(true).getAttribute("GLOBAL_MESSAGE");
		request.getSession().removeAttribute("GLOBAL_MESSAGE");
		return message;
	}
	
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
/*
	// CH 6 SessionRegistry Example
	@Autowired
	SessionRegistry sessionRegistry;
	
	// CH 6 SessionRegistry Usages
	@ModelAttribute("numUsers")
	public int getNumberOfUsers() {
		return sessionRegistry.getAllPrincipals().size();
	}
	*/	
}
