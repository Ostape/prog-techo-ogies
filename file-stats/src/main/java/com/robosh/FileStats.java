package com.robosh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {

    private Map<Character, Long> charactersMap;
    private final Logger logger = LoggerFactory.getLogger(FileStats.class);
    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {
        return new FileStats(fileName);
    }

    private FileStats(String fileName) {
        Path filePath = getPathFromFileName(fileName);
        try {
            List<String> strings = Files.readAllLines(filePath);
            charactersMap = collectCharactersToCountMap(strings.stream());
        } catch (IOException e) {
           logger.error(e.getMessage());
        }
    }


    private static Path getPathFromFileName(String fileName) {
        URL fileUrl = FileStats.class.getClassLoader().getResource(fileName);
        if (fileUrl == null) {
            throw new FileStatsException("No such URL");
        }

        try {
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new FileStatsException("No such file");
        }
    }

    private Map<Character, Long> collectCharactersToCountMap(Stream<String> linesStream) {
        return linesStream
                .flatMap(str -> str.chars().mapToObj(ch -> (char) ch).collect(toList()).stream())
                .filter(ch -> ch != ' ') // filter whitespace
                .collect(groupingBy(identity(), counting()));
    }

    public int getCharCount(char character) {
        return Math.toIntExact(charactersMap.get(character));
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {
        return charactersMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new FileStatsException("There is no characters"))
                .getKey();
    }

    public long getSumCharacters() {
        return charactersMap.values().stream().reduce(0L, (aLong, aLong2) -> aLong + aLong2);
    }

    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return charactersMap.containsKey(character);
    }
}
