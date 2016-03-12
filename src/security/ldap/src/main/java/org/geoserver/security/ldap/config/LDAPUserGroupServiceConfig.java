package org.geoserver.security.ldap.config;

import org.geoserver.security.config.SecurityUserGroupServiceConfig;
import org.geoserver.security.ldap.LDAPBaseSecurityServiceConfig;

public class LDAPUserGroupServiceConfig extends LDAPBaseSecurityServiceConfig implements SecurityUserGroupServiceConfig {

	/** unused */
	protected String passwordEncoderName ;
	protected String passwordPolicyName ;
	
	/** purpose ? Just copy-pasted from there to here */
    private String allGroupsSearchFilter;
    
    /** needs LDAP binding before querying the tree */
    private String user;

    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public String getAllGroupsSearchFilter() {
		return allGroupsSearchFilter;
	}

	public void setAllGroupsSearchFilter(String allGroupsSearchFilter) {
		this.allGroupsSearchFilter = allGroupsSearchFilter;
	}

	@Override
	public String getPasswordEncoderName() {
		return passwordEncoderName;
	}

	@Override
	public void setPasswordEncoderName(String passwordEncoderName) {
		this.passwordEncoderName = passwordEncoderName;
		
	}

	@Override
	public String getPasswordPolicyName() {
		return passwordPolicyName;
	}

	@Override
	public void setPasswordPolicyName(String passwordPolicyName) {
		this.passwordPolicyName = passwordPolicyName;
	}
}
