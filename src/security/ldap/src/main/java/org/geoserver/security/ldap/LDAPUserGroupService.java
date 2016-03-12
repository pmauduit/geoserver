package org.geoserver.security.ldap;

import java.io.IOException;
import java.util.SortedSet;
import java.util.logging.Logger;

import org.geoserver.security.GeoServerSecurityManager;
import org.geoserver.security.GeoServerUserGroupService;
import org.geoserver.security.GeoServerUserGroupStore;
import org.geoserver.security.config.SecurityNamedServiceConfig;
import org.geoserver.security.event.UserGroupLoadedListener;
import org.geoserver.security.impl.AbstractGeoServerSecurityService;
import org.geoserver.security.impl.AbstractUserGroupService;
import org.geoserver.security.impl.GeoServerUser;
import org.geoserver.security.impl.GeoServerUserGroup;
import org.geoserver.security.xml.XMLUserGroupStore;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LDAPUserGroupService extends AbstractGeoServerSecurityService
implements GeoServerUserGroupService {

    static Logger LOGGER = org.geotools.util.logging.Logging.getLogger("org.geoserver.security.ldap");

    private String name;
    private GeoServerSecurityManager securityManager;
    
    private LdapTemplate ldapTemplate;

    @Override
    public void initializeFromConfig(SecurityNamedServiceConfig config)
            throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean canCreateStore() {
        return true;
    }

    @Override
    public GeoServerUserGroupStore createStore() throws IOException {
        // TODO Auto-generated method stub
        
        // ??
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSecurityManager(GeoServerSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public GeoServerSecurityManager getSecurityManager() {
        return securityManager;
    }

    @Override
    public void registerUserGroupLoadedListener(UserGroupLoadedListener listener) {
        // TODO Auto-generated method stub
        // ?
    }

    @Override
    public void unregisterUserGroupLoadedListener(UserGroupLoadedListener listener) {
        // TODO Auto-generated method stub
        // ?
    }

    @Override
    public GeoServerUserGroup getGroupByGroupname(String groupname)
            throws IOException {
        // TODO: use ldapTemplate to query the LDAP for the given groupname
        return null;
    }

    @Override
    public GeoServerUser getUserByUsername(String username) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: use ldapTemplate to query the LDAP for the given username
        return null;
    }

    
    @Override
    public GeoServerUser createUserObject(String username, String password, boolean isEnabled) throws IOException {
        // TODO Auto-generated method stub
        // fire an exception "read-only UserGroupService" ?
        return null;
    }

    @Override
    public GeoServerUserGroup createGroupObject(String groupname, boolean isEnabled) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SortedSet<GeoServerUser> getUsers() throws IOException {
        // TODO: query the LDAP for all users
        return null;
    }

    @Override
    public SortedSet<GeoServerUserGroup> getUserGroups() throws IOException {
        // TODO: query the LDAP for all groups
        return null;
    }

    @Override
    public SortedSet<GeoServerUser> getUsersForGroup(GeoServerUserGroup group)
            throws IOException {
        // TODO: query the LDAP for all users from the given group
        return null;
    }

    @Override
    public SortedSet<GeoServerUserGroup> getGroupsForUser(GeoServerUser user)
            throws IOException {
        // TODO: query the LDAP for all groups from the given user
        return null;
    }

    @Override
    public void load() throws IOException {
        // TODO ??
        
    }

    @Override
    public String getPasswordEncoderName() {
        // TODO ??
        return null;
    }

    @Override
    public String getPasswordValidatorName() {
        // TODO ??
        return null;
    }

    @Override
    public int getUserCount() throws IOException {
        // TODO: query the ldap
        return 0;
    }

    @Override
    public int getGroupCount() throws IOException {
        // TODO: query the ldap
        return 0;
    }

    @Override
    public SortedSet<GeoServerUser> getUsersHavingProperty(String propname)
            throws IOException {
        // TODO ??
        return null;
    }

    @Override
    public int getUserCountHavingProperty(String propname) throws IOException {
        // TODO ??
        return 0;
    }

    @Override
    public SortedSet<GeoServerUser> getUsersNotHavingProperty(String propname)
            throws IOException {
        // TODO ??
        return null;
    }

    @Override
    public int getUserCountNotHavingProperty(String propname)
            throws IOException {
        // TODO ??
        return 0;
    }

    @Override
    public SortedSet<GeoServerUser> getUsersHavingPropertyValue(String propname,
            String propvalue) throws IOException {
        // TODO ??
        return null;
    }

    @Override
    public int getUserCountHavingPropertyValue(String propname,
            String propvalue) throws IOException {
        // TODO ??
        return 0;
    }
}
