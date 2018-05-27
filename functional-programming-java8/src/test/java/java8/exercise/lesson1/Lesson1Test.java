package java8.exercise.lesson1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class Lesson1Test {

    Lesson1 lesson1 = new Lesson1();

    @Test
    public void testExercise1() {
        List<String> list = Arrays.asList(
            "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        Assert.assertEquals("abcdef", lesson1.exercise1(list));
    }

    @Test
    public void testExercise2() {
        List<String> list = new ArrayList<>(Arrays.asList(
            "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        Assert.assertEquals(Arrays.asList("echo"), lesson1.exercise2(list));
    }

    @Test
    public void testExercise3() {
        List<String> list = new ArrayList<>(Arrays.asList(
            "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        Assert.assertEquals(Arrays.asList(
            "ALPHA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT"), lesson1.exercise3(list));
    }

    @Test
    public void testExercise4() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        Assert.assertEquals("a1,b2,c3", lesson1.exercise4(map));
    }

    @Test
    public void testExercise5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        lesson1.exercise5(list);

        String result = new String(baos.toByteArray());
        Assert.assertEquals("1\r\n2\r\n3\r\n4\r\n5\r\n", result);
        System.setOut(oldOut);
    }
}
