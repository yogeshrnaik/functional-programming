/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved. JDK 8 MOOC Lesson 2 homework
 */
package java8.exercise.lesson2.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.exercise.lesson2.Lesson2;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson2Solution extends Lesson2 {

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Exercise 1 Create a new list with all the strings from original list converted to lower case and print them out.
     */
    public void exercise1(List<String> list) {
        /* YOUR CODE HERE */
        list.stream().map(String::toLowerCase).forEach(System.out::println);
    }

    /**
     * Exercise 2 Modify exercise 1 so that the new list only contains strings that have an odd length
     */
    public void exercise2(List<String> list) {
        /* YOUR CODE HERE */
        list.stream().map(String::toLowerCase).filter(e -> e.length() % 2 != 0).forEach(System.out::println);
    }

    /**
     * Exercise 3 Join the second, third and forth strings of the list into a single string, <br/>
     * where each word is separated by a hyphen (-).
     */
    public String exercise3(List<String> list) {
        /* YOUR CODE HERE */
        return list.subList(1, 4).stream().collect(Collectors.joining("-"));
        // list.subList(1, 4).stream().reduce((s1, s2) -> s1 + "-" + s2).ifPresent(System.out::println);
    }

    /**
     * Count the number of lines in the file using the BufferedReader
     */
    public long exercise4(String filePath) throws IOException {
        /* YOUR CODE HERE */
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(filePath), StandardCharsets.UTF_8)) {
            return reader.lines().count();
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with no duplicates contained in the file. <br/>
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     * 
     * @param filePath TODO
     */
    public List<String> exercise5(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(filePath), StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            return reader.lines()
                .flatMap(e -> Stream.of(e.split(WORD_REGEXP)))
                .distinct().collect(Collectors.toList());
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from the file, converted to lower-case and with duplicates
     * removed, which is sorted by natural order.
     * 
     * @param filePath TODO
     */
    public List<String> exercise6(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(filePath), StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            return reader.lines().map(String::toLowerCase)
                .flatMap(e -> Stream.of(e.split(WORD_REGEXP)))
                .distinct().sorted()
                .collect(Collectors.toList());
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    public List<String> exercise7(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(filePath), StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            return reader.lines().map(String::toLowerCase)
                .flatMap(e -> Stream.of(e.split(WORD_REGEXP)))
                .distinct()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        }
    }
}
