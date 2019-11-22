package com.robosh;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    private FileReaders(){}
    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        Path filePath = getPathFromFileName(fileName);
        Stream<String> lines = null;
        try {
            lines = Files.lines(filePath);
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileException();
        } finally {
            if (Objects.nonNull(lines)) {
                lines.close();
            }
        }
    }

    private static Path getPathFromFileName(String fileName) {
        URL fileUrl = FileReaders.class.getClassLoader().getResource(fileName);
        if (fileUrl == null) {
            throw new FileException("No such URL");
        }

        try {
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new FileException("No such URI");
        }
    }
}
