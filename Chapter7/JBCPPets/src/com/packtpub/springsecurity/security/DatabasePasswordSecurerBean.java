/**
 * 
 */
package com.packtpub.springsecurity.security;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Secures the database by updating user passwords.
 * 
 * @author Mularien
 */
public class DatabasePasswordSecurerBean extends JdbcDaoSupport {
	@Autowired
	private PasswordEncoder passwordEncoder;
	// Ch 4 Salt Exercise
	@Autowired
	private SaltSource saltSource;
	@Autowired
	private UserDetailsService userDetailsService;
	
	public void secureDatabase() {
		getJdbcTemplate().query("select username, password from users", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				String password = rs.getString(2);
				// Ch 4 Salt Exercise
				UserDetails user = userDetailsService.loadUserByUsername(username);
				String encodedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user));
//				String encodedPassword = passwordEncoder.encodePassword(password, null);
				getJdbcTemplate().update("update users set password = ? where username = ?", 
						encodedPassword, 
						username);
				logger.debug("Updating password for username: "+username+" to: "+encodedPassword);
			}			
		});
	}
}
