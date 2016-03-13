package org.geoserver.web.security.ldap;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.geoserver.security.ldap.LDAPRoleServiceConfig;
import org.geoserver.security.ldap.config.LDAPUserGroupServiceConfig;
import org.geoserver.security.web.usergroup.UserGroupServicePanel;
import org.geoserver.web.security.ldap.LDAPRoleServicePanel.LDAPAuthenticationPanel;

public class LDAPUserGroupServicePanel extends UserGroupServicePanel<LDAPUserGroupServiceConfig> {
    class LDAPAuthenticationPanel extends FormComponentPanel {
        
        public LDAPAuthenticationPanel(String id) {
            super(id, new Model());
            add(new TextField("adminUserDn"));
        
            PasswordTextField pwdField = new PasswordTextField("adminPassword");
            // avoid reseting the password which results in an
            // empty password on saving a modified configuration
            pwdField.setResetPassword(false);
            add(pwdField);
        }
        
        public void resetModel() {
            get("adminUserDn").setDefaultModelObject(null);
            get("adminPassword").setDefaultModelObject(null);
        }
    }
	public LDAPUserGroupServicePanel(String id, IModel<LDAPUserGroupServiceConfig> model) {
		super(id, model);
		/** LDAP server parameters */
		add(new TextField("serverUrl").setRequired(true));
		add(new CheckBox("useTLS"));
		/** group options */
		add(new TextField("groupsSearchFilter"));
		add(new TextField("groupsSearchBase"));
		add(new TextField("groupNameAttribute"));
		add(new TextField("userGroupSearchFilter"));
		/** user options */
		add(new TextField("userSearchFilter"));
		add(new TextField("userSearchBase"));
		add(new TextField("userNameAttribute"));

		/** privileged account for querying the LDAP server (if needed) */
		add(new AjaxCheckBox("needLdapBind") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				WebMarkupContainer c = (WebMarkupContainer) LDAPUserGroupServicePanel.this
						.get("authenticationPanelContainer");

				// reset any values that were set
				LDAPAuthenticationPanel ldapAuthenticationPanel = (LDAPAuthenticationPanel) c
						.get("authenticationPanel");
				ldapAuthenticationPanel.resetModel();
				ldapAuthenticationPanel.setVisible(getModelObject().booleanValue());
				target.addComponent(c);
			}
		});
		LDAPAuthenticationPanel authPanel = new LDAPAuthenticationPanel("authenticationPanel");
		authPanel.setVisible(model.getObject().getNeedLdapBind());
		add(new WebMarkupContainer("authenticationPanelContainer").add(authPanel).setOutputMarkupId(true));
	}
}
