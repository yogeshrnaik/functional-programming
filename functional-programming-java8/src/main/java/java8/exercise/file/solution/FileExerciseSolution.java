package java8.exercise.file.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java8.exercise.file.FileExercise;

public class FileExerciseSolution extends FileExercise {

    /**
     * Find the length of the longest line in a file
     * 
     * @throws IOException
     */
    @Override
    public int getLongestLineLength(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
            .mapToInt(String::length)
            .max()
            .getAsInt();
    }

    /**
     * Find the longest line in a file
     * 
     * @throws IOException
     */
    @Override
    public String getLongestLine(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
            .reduce((l1, l2) -> l1.length() > l2.length() ? l1 : l2)
            .get();
    }
}
