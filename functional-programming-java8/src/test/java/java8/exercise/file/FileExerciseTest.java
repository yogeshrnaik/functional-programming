package java8.exercise.file;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class FileExerciseTest {

    private final FileExercise exercise = new FileExercise();

    @Test
    public void testLongestLineLengthFromSonnetIFile() throws IOException {
        assertEquals(53, exercise.getLongestLineLength("src/main/resources/SonnetI.txt"));
    }

    @Test
    public void testLongestLineLengthFromWordsFile() throws IOException {
        assertEquals(24, exercise.getLongestLineLength("src/main/resources/words"));
    }

    @Test
    public void testLongestLineFromSonnetIFile() throws IOException {
        assertEquals("Feed'st thy light's flame with self-substantial fuel,", exercise.getLongestLine("src/main/resources/SonnetI.txt"));
    }

    @Test
    public void testLongestLineFromWordsFile() throws IOException {
        assertEquals("thyroparathyroidectomize", exercise.getLongestLine("src/main/resources/words"));
    }
}
