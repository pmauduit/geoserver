/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

package org.geoserver.test;

import java.io.File;

/**
 * Mock data for testing feature chaining with simple content type (gml:name).
 *
 * @author Rini Angreani, CSIRO Earth Science and Resource Engineering
 */
public class SimpleAttributeFeatureChainMockData extends AbstractAppSchemaMockData {

    public SimpleAttributeFeatureChainMockData(File tempFolder) {
        super(tempFolder);
    }

    /** @see org.geoserver.test.AbstractAppSchemaMockData#addContent() */
    @Override
    public void addContent() {
        addFeatureType(
                GSML_PREFIX,
                "MappedFeature",
                "SimpleAttributeFeatureChainTest.xml",
                "MappedFeatureNameOne.properties",
                "MappedFeatureNameTwo.properties",
                "MappedFeatureWithNestedName.properties",
                "MappedFeaturePoints.properties",
                "MappedFeaturePolygons.properties");
    }
}
