package com.packtpub.springsecurity.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.web.filter.GenericFilterBean;

/**
 * A filter which pulls from the HTTP request several fields, including username, password,
 * and a signature incorporating the combination of the two. 
 * 
 * @author Mularien
 */
public class RequestHeaderProcessingFilter extends AbstractAuthenticationProcessingFilter {
	private String usernameHeader = "j_username";
	private String passwordHeader = "j_password";
	private String signatureHeader = "j_signature";
	
	/**
	 * {@inheritDoc}
	 */
	protected RequestHeaderProcessingFilter() {
        super("/j_spring_security_filter");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
        String username = request.getHeader(usernameHeader);
        String password = request.getHeader(passwordHeader);
        String signature = request.getHeader(signatureHeader);

        SignedUsernamePasswordAuthenticationToken authRequest = 
        	new SignedUsernamePasswordAuthenticationToken(username, password, signature);

        return this.getAuthenticationManager().authenticate(authRequest);		
	}

	/**
	 * @return the usernameHeader
	 */
	public String getUsernameHeader() {
		return usernameHeader;
	}

	/**
	 * @param usernameHeader the usernameHeader to set
	 */
	public void setUsernameHeader(String usernameHeader) {
		this.usernameHeader = usernameHeader;
	}

	/**
	 * @return the passwordHeader
	 */
	public String getPasswordHeader() {
		return passwordHeader;
	}

	/**
	 * @param passwordHeader the passwordHeader to set
	 */
	public void setPasswordHeader(String passwordHeader) {
		this.passwordHeader = passwordHeader;
	}

	/**
	 * @return the signatureHeader
	 */
	public String getSignatureHeader() {
		return signatureHeader;
	}

	/**
	 * @param signatureHeader the signatureHeader to set
	 */
	public void setSignatureHeader(String signatureHeader) {
		this.signatureHeader = signatureHeader;
	}	
}
