package org.geoserver.security.ldap.config;

import org.geoserver.security.config.BaseSecurityNamedServiceConfig;
import org.geoserver.security.config.SecurityUserGroupServiceConfig;
import org.geoserver.security.password.PasswordEncodingType;
import org.geoserver.security.password.PasswordValidator;

public class LDAPUserGroupServiceConfig extends BaseSecurityNamedServiceConfig implements SecurityUserGroupServiceConfig {

	private static final long serialVersionUID = 4699211240178341515L;

	/** unused (but necessary for a UserGroupService) */
	protected String passwordEncoderName = PasswordEncodingType.EMPTY.toString();
	protected String passwordPolicyName = PasswordValidator.DEFAULT_NAME;

	/** LDAP server parameters */
	protected String serverUrl = "ldap://localhost:389/";
	protected Boolean useTLS = false;
	
	/** groups options */
    protected String groupsSearchFilter    = "objectClass=groupOfMembers";
	protected String groupsSearchBase       = "ou=groups,dc=georchestra,dc=org";
    protected String groupNameAttribute    = "cn";
    protected String userGroupSearchFilter = "member=uid={0},ou=users,dc=georchestra,dc=org";

    /** users options */
    protected String userSearchFilter  = "objectClass=inetOrgPerson";
    protected String userSearchBase    = "ou=users,dc=georchestra,dc=org";
    protected String userNameAttribute = "uid";
    
    /** if needing LDAP binding before querying the server */

    protected Boolean needLdapBind = false;
    protected String adminUserDn = null;
	protected String adminPassword = null;

	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public Boolean getUseTLS() {
		return useTLS;
	}
	public void setUseTLS(Boolean useTLS) {
		this.useTLS = useTLS;
	}
	public String getGroupsSearchFilter() {
		return groupsSearchFilter;
	}
	public void setGroupsSearchFilter(String groupsSearchFilter) {
		this.groupsSearchFilter = groupsSearchFilter;
	}
    public String getGroupsSearchBase() {
		return groupsSearchBase;
	}
	public void setGroupsSearchBase(String groupSearchBase) {
		this.groupsSearchBase = groupSearchBase;
	}
	public String getGroupNameAttribute() {
		return groupNameAttribute;
	}
	public void setGroupNameAttribute(String groupNameAttribute) {
		this.groupNameAttribute = groupNameAttribute;
	}
	public String getUserGroupSearchFilter() {
		return userGroupSearchFilter;
	}
	public void setUserGroupSearchFilter(String userGroupSearchFilter) {
		this.userGroupSearchFilter = userGroupSearchFilter;
	}
	public String getUserSearchFilter() {
		return userSearchFilter;
	}
	public void setUserSearchFilter(String userSearchFilter) {
		this.userSearchFilter = userSearchFilter;
	}
	public String getUserSearchBase() {
		return userSearchBase;
	}
	public void setUserSearchBase(String userSearchBase) {
		this.userSearchBase = userSearchBase;
	}
	public String getUserNameAttribute() {
		return userNameAttribute;
	}
	public void setUserNameAttribute(String userNameAttribute) {
		this.userNameAttribute = userNameAttribute;
	}
	public Boolean getNeedLdapBind() {
		return needLdapBind;
	}
	public void setNeedLdapBind(Boolean needLdapBind) {
		this.needLdapBind = needLdapBind;
	}
	public String getAdminUserDn() {
		return adminUserDn;
	}
	public void setAdminUserDn(String adminUserDn) {
		this.adminUserDn = adminUserDn;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/** unused */
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
