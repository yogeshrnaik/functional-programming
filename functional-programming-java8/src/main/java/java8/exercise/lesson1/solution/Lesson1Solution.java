/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved. JDK 8 MOOC Lesson 1 homework
 */
package java8.exercise.lesson1.solution;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lesson1Solution {

    /**
     * All exercises should be completed using Lambda expressions and the new methods added to JDK 8 where appropriate. <br/>
     * There is no need to use an explicit loop in any of the code. <br/>
     * Use method references rather than full lambda expressions wherever possible.
     */
    /**
     * Exercise 1 Create a string that consists of the first letter of each word in the list of Strings provided.
     */
    public String exercise1(List<String> list) {
        /* YOUR CODE HERE */
        return list.stream().map(e -> e.substring(0, 1)).collect(Collectors.joining());
    }

    /**
     * Exercise 2 Remove the words that have odd lengths from the list.
     */
    public List<String> exercise2(List<String> list) {
        /* YOUR CODE HERE */
        list.removeIf(e -> e.length() % 2 != 0);
        return list;
    }

    /**
     * Exercise 3 Replace every word in the list with its upper case equivalent.
     */
    public List<String> exercise3(List<String> list) {
        /* YOUR CODE HERE */
        list.replaceAll(String::toUpperCase);
        return list;
    }

    /**
     * Exercise 4 Convert every key-value pair of the map into a string and append them all into a single string, in iteration order.
     */
    public String exercise4(Map<String, Integer> map) {
        /* YOUR CODE HERE */
        return map.entrySet().stream().map(e -> e.getKey() + e.getValue()).collect(Collectors.joining(","));
    }

    /**
     * Exercise 5 Print all items from list on System.out.println()
     */
    public void exercise5(List<Integer> list) {
        /* YOUR CODE HERE */
        list.forEach(System.out::println);
    }

}
