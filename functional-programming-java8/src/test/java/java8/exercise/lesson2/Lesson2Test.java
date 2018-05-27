package java8.exercise.lesson2;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson2Test {

    Lesson2 lesson2 = new Lesson2();

    private static PrintStream oldOut;
    private static ByteArrayOutputStream baos;

    @Before
    public void setup() {
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @After
    public void cleanup() {
        System.setOut(oldOut);
    }

    @Test
    public void testExercise1() {
        List<String> list = Arrays.asList(
            "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        lesson2.exercise1(list);

        String result = new String(baos.toByteArray());
        Assert.assertEquals("the\r\n" +
            "quick\r\n" +
            "brown\r\n" +
            "fox\r\n" +
            "jumped\r\n" +
            "over\r\n" +
            "the\r\n" +
            "lazy\r\n" +
            "dog\r\n", result);
    }

    @Test
    public void testExercise2() {
        List<String> list = Arrays.asList(
            "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        lesson2.exercise2(list);

        String result = new String(baos.toByteArray());
        Assert.assertEquals("the\r\n" +
            "quick\r\n" +
            "brown\r\n" +
            "fox\r\n" +
            "the\r\n" +
            "dog\r\n", result);
    }

    @Test
    public void testExercise3() {
        List<String> list = Arrays.asList(
            "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        Assert.assertEquals("quick-brown-fox", lesson2.exercise3(list));
    }

    @Test
    public void testExercise4() throws IOException {
        Assert.assertEquals(14, lesson2.exercise4("src/main/resources/SonnetI.txt"));
    }

    @Test
    public void testExercise5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("src/main/resources/Lesson2Exercise5Result.txt"), StandardCharsets.UTF_8)) {
            Assert.assertEquals(reader.lines().collect(toList()),
                lesson2.exercise5("src/main/resources/SonnetI.txt"));
        }
    }

    @Test
    public void testExercise6() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("src/main/resources/Lesson2Exercise6Result.txt"), StandardCharsets.UTF_8)) {
            Assert.assertEquals(reader.lines().collect(toList()),
                lesson2.exercise6("src/main/resources/SonnetI.txt"));
        }
    }

    @Test
    public void testExercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("src/main/resources/Lesson2Exercise7Result.txt"), StandardCharsets.UTF_8)) {
            Assert.assertEquals(reader.lines().collect(toList()),
                lesson2.exercise7("src/main/resources/SonnetI.txt"));
        }
    }
}
