/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved. JDK 8 MOOC Lesson 2 homework
 */
package java8.exercise.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson2 {

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Exercise 1 Create a new list with all the strings from original list converted to lower case and print them out.
     */
    public void exercise1(List<String> list) {
        /* YOUR CODE HERE */
    }

    /**
     * Exercise 2 Modify exercise 1 so that the new list only contains strings that have an odd length
     */
    public void exercise2(List<String> list) {
        /* YOUR CODE HERE */
    }

    /**
     * Exercise 3 Join the second, third and forth strings of the list into a single string, <br/>
     * where each word is separated by a hyphen (-).
     */
    public String exercise3(List<String> list) {
        /* YOUR CODE HERE */
        return null;
    }

    /**
     * Count the number of lines in the file using the BufferedReader
     */
    public long exercise4(String filePath) throws IOException {
        /* YOUR CODE HERE */
        return 0;
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

            return null;
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

            return null;
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    public List<String> exercise7(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(filePath), StandardCharsets.UTF_8)) {

            return null;
        }
    }
}
