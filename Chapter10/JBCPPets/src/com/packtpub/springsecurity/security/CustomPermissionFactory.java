package com.packtpub.springsecurity.security;

import java.util.Map;

import org.springframework.security.acls.domain.DefaultPermissionFactory;
import org.springframework.security.acls.model.Permission;

/**
 * @author Mularien
 *
 */
public class CustomPermissionFactory extends DefaultPermissionFactory {

	/**
	 * Default constructor.
	 */
	public CustomPermissionFactory() {
		super();
		registerPublicPermissions(CustomPermission.class);
	}

	// we don't use these
	/**
	 * {@inheritDoc}
	 */
	public CustomPermissionFactory(Class<? extends Permission> permissionClass) {
		super(permissionClass);
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomPermissionFactory(
			Map<String, ? extends Permission> namedPermissions) {
		super(namedPermissions);
	}

}
