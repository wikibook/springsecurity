package com.packtpub.springsecurity.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

/**
 * Simple LdapAuthoritiesPopulator implementation which assigns a particular role
 * to any authenticated user.
 * 
 * @author Mularien
 */
public class SimpleRoleGrantingLdapAuthoritiesPopulator implements
		LdapAuthoritiesPopulator {
	protected String role = "ROLE_USER";
	
	/* (non-Javadoc)
	 * @see org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator#getGrantedAuthorities(org.springframework.ldap.core.DirContextOperations, java.lang.String)
	 */
	@Override
	public Collection<GrantedAuthority> getGrantedAuthorities(
			DirContextOperations userData, String username) {
		GrantedAuthority ga = new GrantedAuthorityImpl(role);
		return Arrays.asList(ga); 
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
}
