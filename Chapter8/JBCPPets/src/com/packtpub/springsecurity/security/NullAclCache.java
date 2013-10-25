/**
 * 
 */
package com.packtpub.springsecurity.security;

import java.io.Serializable;

import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.ObjectIdentity;

/**
 * Implement a null ACL cache.
 * 
 * @author Mularien
 */
public class NullAclCache implements AclCache {

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#clearCache()
	 */
	@Override
	public void clearCache() {
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#evictFromCache(java.io.Serializable)
	 */
	@Override
	public void evictFromCache(Serializable arg0) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#evictFromCache(org.springframework.security.acls.model.ObjectIdentity)
	 */
	@Override
	public void evictFromCache(ObjectIdentity arg0) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#getFromCache(org.springframework.security.acls.model.ObjectIdentity)
	 */
	@Override
	public MutableAcl getFromCache(ObjectIdentity arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#getFromCache(java.io.Serializable)
	 */
	@Override
	public MutableAcl getFromCache(Serializable arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.jdbc.AclCache#putInCache(org.springframework.security.acls.model.MutableAcl)
	 */
	@Override
	public void putInCache(MutableAcl arg0) {
	}

}
