package org.geoserver.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOUtils {

    /**
     * Creates a directory as a child of baseDir. The directory name will be preceded by prefix and followed by suffix
     */
    public static File createRandomDirectory(String baseDir, String prefix) throws IOException {
        Path tmpPath = java.nio.file.Files.createTempDirectory(Paths.get(baseDir), prefix);

        return tmpPath.toFile();
    }
}
