/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

package org.geoserver.test;

import java.io.File;
import org.geoserver.data.test.MockData;

/**
 * Mock data for testing SRS encoding in app-schema {@link SRSWfsTest}
 *
 * <p>Inspired by {@link MockData}.
 *
 * @author Rini Angreani, Curtin University of Technology
 */
public class SRSMockData extends AbstractAppSchemaMockData {

    /** Prefix for ex namespace. */
    protected static final String EX_PREFIX = "ex";

    /** URI for ex namespace. */
    protected static final String EX_URI = "http://example.com";

    public SRSMockData(File tempFolder) {
        super(tempFolder);
    }

    /** @see org.geoserver.test.AbstractAppSchemaMockData#addContent() */
    @Override
    public void addContent() {
        putNamespace(EX_PREFIX, EX_URI);
        addFeatureType(
                EX_PREFIX, "geomContainer", "SRSTest.xml", "SRSTestPropertyfile.properties", "NestedGeometry.xsd");
    }
}
