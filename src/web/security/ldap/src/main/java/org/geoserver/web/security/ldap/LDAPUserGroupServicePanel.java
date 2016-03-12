package org.geoserver.web.security.ldap;


import org.apache.wicket.model.IModel;
import org.geoserver.security.ldap.config.LDAPUserGroupServiceConfig;
import org.geoserver.security.web.usergroup.UserGroupServicePanel;

public class LDAPUserGroupServicePanel extends UserGroupServicePanel<LDAPUserGroupServiceConfig> {

	public LDAPUserGroupServicePanel(String id, IModel<LDAPUserGroupServiceConfig> model) {
		super(id, model);
	}

}
