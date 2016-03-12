package org.geoserver.web.security.ldap;


import org.geoserver.security.ldap.LDAPUserGroupService;
import org.geoserver.security.ldap.config.LDAPUserGroupServiceConfig;
import org.geoserver.security.web.usergroup.UserGroupServicePanelInfo;

public class LDAPUserGroupServicePanelInfo
	extends UserGroupServicePanelInfo<LDAPUserGroupServiceConfig, LDAPUserGroupServicePanel>  {

    public LDAPUserGroupServicePanelInfo() {
        setComponentClass(LDAPUserGroupServicePanel.class);
        setServiceClass(LDAPUserGroupService.class);
        setServiceConfigClass(LDAPUserGroupServiceConfig.class);
    }
}
