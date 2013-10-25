package com.packtpub.springsecurity.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class OpenIDAuthenticationFailureHandler extends
	SimpleUrlAuthenticationFailureHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		if(exception instanceof UsernameNotFoundException 
				&& exception.getAuthentication() instanceof OpenIDAuthenticationToken
				&& ((OpenIDAuthenticationToken)exception.getAuthentication()).getStatus().equals(OpenIDAuthenticationStatus.SUCCESS)) {
			DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
			request.getSession(true).setAttribute("USER_OPENID_CREDENTIAL", ((UsernameNotFoundException)exception).getExtraInformation());
			// Ch 8 AX Experimentation
			OpenIDAuthenticationToken openIdAuth = (OpenIDAuthenticationToken)exception.getAuthentication();
			for(OpenIDAttribute attr : openIdAuth.getAttributes()) {
				System.out.printf("AX Attribute: %s, Type: %s, Count: %d\n", attr.getName(), attr.getType(), attr.getCount());
				for(String value : attr.getValues()) {
					System.out.printf(" Value: %s\n", value);
				}
			}
			// redirect to create account page
			redirectStrategy.sendRedirect(request, response, "/registrationOpenid.do");
		} else {
			super.onAuthenticationFailure(request, response, exception);
		}
	}
	
}
