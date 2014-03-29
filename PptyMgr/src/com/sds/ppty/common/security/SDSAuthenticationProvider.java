package com.sds.ppty.common.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sds.ppty.dao.common.SDSAuthDAO;
import com.sds.ppty.prl.test.TestController;

public class SDSAuthenticationProvider implements AuthenticationProvider, UserDetailsService {
	
	static final Logger logger = LogManager.getLogger(SDSAuthenticationProvider.class.getName());
	
	private SDSAuthDAO authDAO;
	
	public SDSAuthDAO getAuthDAO() {
		return authDAO;
	}

	public void setAuthDAO(SDSAuthDAO authDAO) {
		this.authDAO = authDAO;
	}

	private static final List<GrantedAuthority> AUTHORITIES  = new ArrayList<GrantedAuthority>();

	static {
	    AUTHORITIES.add(new GrantedAuthorityImpl("ROLE_USER"));
	    AUTHORITIES.add(new GrantedAuthorityImpl("ROLE_TELLER"));
	}
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		logger.info("Authenticating user - "+auth.getName());
		/* if (auth.getName().equals(auth.getCredentials())) {
			 //System.out.println(auth.getName()+"--"+auth.getCredentials());
            return new UsernamePasswordAuthenticationToken(auth.getName(),
                auth.getCredentials(), AUTHORITIES);
        }
 
        throw new BadCredentialsException("Bad Credentials");*/
		String name = auth.getName();
        String password = auth.getCredentials().toString();
        
        if (name.equals("admin") && password.equals("system")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            String role =  this.getAuthDAO().getUserRole(name);
            System.out.println(role);
            grantedAuths.add(new GrantedAuthorityImpl(role));
            grantedAuths.add(new GrantedAuthorityImpl("ROLE_USER"));
             auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
		
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		if ( authentication == null ) return false;		 
        return Authentication.class.isAssignableFrom(authentication);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails user = new User(username, "", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
				
		return user;
	}

}
