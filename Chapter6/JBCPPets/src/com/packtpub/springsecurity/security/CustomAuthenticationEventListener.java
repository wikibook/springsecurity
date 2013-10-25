package com.packtpub.springsecurity.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEventListener implements
		ApplicationListener<AbstractAuthenticationEvent> {

	@Override
	public void onApplicationEvent(AbstractAuthenticationEvent event) {
		System.out.println("Received event of type: "+event.getClass().getName()+": "+event.toString());
	}

}
