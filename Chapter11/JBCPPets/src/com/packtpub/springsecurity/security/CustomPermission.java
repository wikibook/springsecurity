/**
 * 
 */
package com.packtpub.springsecurity.security;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.model.Permission;

/**
 * Adds a permission to allow read of administrative read-protected resources.
 * 
 * @author Mularien
 */
@SuppressWarnings("serial")
public class CustomPermission extends BasePermission {

	protected CustomPermission(int mask, char code) {
		super(mask, code);
	}

	protected CustomPermission(int mask) {
		super(mask);
	}

    public static final Permission ADMIN_READ = new CustomPermission(1 << 5, 'M'); // 32
}
