package com.packtpub.springsecurity.web;

import java.util.Calendar;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

public class CustomWebSecurityExpressionRoot extends SecurityExpressionRoot {
	FilterInvocation filterInvocation;
	
	public CustomWebSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
		super(a);
		this.filterInvocation = fi;
	}

	public boolean isEvenMinute() {
		return (Calendar.getInstance().get(Calendar.MINUTE) % 2) == 0;
	}
}
