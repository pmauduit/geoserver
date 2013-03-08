package org.geoserver.security;

import static org.geoserver.security.GeoServerSecurityFilterChain.ANONYMOUS_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.BASIC_AUTH_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.DEFAULT_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.DYNAMIC_EXCEPTION_TRANSLATION_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.FILTER_SECURITY_INTERCEPTOR;
import static org.geoserver.security.GeoServerSecurityFilterChain.FILTER_SECURITY_REST_INTERCEPTOR;
import static org.geoserver.security.GeoServerSecurityFilterChain.FORM_LOGIN_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.FORM_LOGOUT_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.GUI_EXCEPTION_TRANSLATION_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.GWC_REST_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.GWC_WEB_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.REST_CHAIN;
import static org.geoserver.security.GeoServerSecurityFilterChain.SECURITY_CONTEXT_ASC_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.SECURITY_CONTEXT_NO_ASC_FILTER;
import static org.geoserver.security.GeoServerSecurityFilterChain.WEB_CHAIN;

import java.util.ArrayList;
import java.util.List;

/**
 * GEORCHESTRA class for setting up initial filters and chains
 *
 * @author jeichar
 */
public class GeorchestraSecurityFilterChain {

	public static final String PROXY_FILTER = "proxy";
	public static String LOGOUT_FILTER = "proxy_logout";
	public static String LOGIN_FILTER = "proxy_login";


    static RequestFilterChain WEB = new ServiceLoginFilterChain(WEB_CHAIN, GWC_WEB_CHAIN);
    static {
        WEB.setName("web");
        WEB.setFilterNames(SECURITY_CONTEXT_ASC_FILTER, PROXY_FILTER, ANONYMOUS_FILTER,
            GUI_EXCEPTION_TRANSLATION_FILTER, FILTER_SECURITY_INTERCEPTOR);
    }

    private static RequestFilterChain WEB_LOGIN = new ServiceLoginFilterChain(FORM_LOGIN_CHAIN);
    static {
        WEB_LOGIN.setName("webLogin");
        WEB_LOGIN.setFilterNames(SECURITY_CONTEXT_ASC_FILTER, LOGIN_FILTER);
    }

    private static RequestFilterChain WEB_LOGOUT = new ServiceLoginFilterChain(FORM_LOGOUT_CHAIN);
    static {
        WEB_LOGOUT.setName("webLogout");
        WEB_LOGOUT.setFilterNames(SECURITY_CONTEXT_ASC_FILTER, LOGOUT_FILTER);
    }

    private static RequestFilterChain REST = new ServiceLoginFilterChain(REST_CHAIN);
    static {
        REST.setName("rest");
        REST.setFilterNames(SECURITY_CONTEXT_NO_ASC_FILTER, PROXY_FILTER, BASIC_AUTH_FILTER, ANONYMOUS_FILTER, 
            DYNAMIC_EXCEPTION_TRANSLATION_FILTER, FILTER_SECURITY_REST_INTERCEPTOR);
    }

    private static RequestFilterChain GWC = new ServiceLoginFilterChain(GWC_REST_CHAIN);
    static {
        GWC.setName("gwc");
        GWC.setFilterNames(SECURITY_CONTEXT_NO_ASC_FILTER, PROXY_FILTER, BASIC_AUTH_FILTER, 
            DYNAMIC_EXCEPTION_TRANSLATION_FILTER, FILTER_SECURITY_REST_INTERCEPTOR);
    }

    private static RequestFilterChain DEFAULT = new ServiceLoginFilterChain(DEFAULT_CHAIN);
    static {
        DEFAULT.setName("default");
        DEFAULT.setFilterNames(SECURITY_CONTEXT_NO_ASC_FILTER, PROXY_FILTER, BASIC_AUTH_FILTER, ANONYMOUS_FILTER, 
            DYNAMIC_EXCEPTION_TRANSLATION_FILTER, FILTER_SECURITY_INTERCEPTOR);
    }

    static List<RequestFilterChain> INITIAL = new ArrayList<RequestFilterChain>();


    static {
        INITIAL.add(WEB);
        INITIAL.add(WEB_LOGIN);
        INITIAL.add(WEB_LOGOUT);
        INITIAL.add(REST);
        INITIAL.add(GWC);
        INITIAL.add(DEFAULT);
    }
}
