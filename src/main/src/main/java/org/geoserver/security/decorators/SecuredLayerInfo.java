/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.decorators;

import org.geoserver.catalog.CoverageInfo;
import org.geoserver.catalog.FeatureTypeInfo;
import org.geoserver.catalog.LayerInfo;
import org.geoserver.catalog.ResourceInfo;
import org.geoserver.catalog.WMSLayerInfo;
import org.geoserver.security.SecureCatalogImpl;
import org.geoserver.security.WrapperPolicy;

public class SecuredLayerInfo extends DecoratingLayerInfo {

    WrapperPolicy policy;

    public SecuredLayerInfo(LayerInfo delegate, WrapperPolicy  policy) {
        super(delegate);
        this.policy = policy;
    }
    
    public WrapperPolicy getWrapperPolicy() {
        return policy;
    }

    @Override
    public ResourceInfo getResource() {
        ResourceInfo r = super.getResource();

        if (r == null) {
            return null;
        }
        // geOrchestra #885: Applying same reflection fiddling
        Class proxiedInterface = null;

        Class[] itfs = r.getClass().getInterfaces();
        if (itfs.length > 0) {
            proxiedInterface = itfs[0];
        }

        if (r instanceof FeatureTypeInfo)
            return new SecuredFeatureTypeInfo((FeatureTypeInfo) r, policy);
        else if (r instanceof CoverageInfo)            
            return new SecuredCoverageInfo((SecuredCoverageInfo) r, policy);
        else if (r instanceof WMSLayerInfo)
            return new SecuredWMSLayerInfo((WMSLayerInfo) r, policy);
        // if r is already a SecuredBlah object
        else if (proxiedInterface != null && proxiedInterface.isAssignableFrom(SecuredFeatureTypeInfo.class)
                || (proxiedInterface != null && proxiedInterface.isAssignableFrom(SecuredCoverageInfo.class))
                || (proxiedInterface != null && proxiedInterface.isAssignableFrom(SecuredWMSLayerInfo.class)))
            return r;
        
            
        else
            throw new RuntimeException("Don't know how to make resource of type " + r.getClass());
    }


    @Override
    public void setResource(ResourceInfo resource) {
        if (resource instanceof SecuredFeatureTypeInfo || resource instanceof SecuredCoverageInfo) {
            resource = (ResourceInfo) SecureCatalogImpl.unwrap(resource);
        }

        delegate.setResource(resource);
    }
}
