package coreservlets.readfiles2;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import coreservlets.strings.*;

/** Prints all palindromes and all n-length palindromes. Uses the second
 *  file-reading variation, where the code is split into a file-processing method
 *  and a stream-processing method, but code in the file-processing method is
 *  repeated from example to example.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java). Java 9 topics coming soon.</a>.
 */

public class FileUtils {
  
  /** Prints all palindromes in the Stream. */
  
  public static void printAllPalindromes(Stream<String> words) {
    words.filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints all palindromes in the file. */
  
  public static void printAllPalindromes(String filename) {
    try(Stream<String> words = Files.lines(Paths.get(filename))) {
      printAllPalindromes(words);
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
    }
  }
  
  /** Prints the n-length palindromes in the Stream. */
  
  public static void printPalindromes(Stream<String> words, int length) {
    words.filter(word -> word.length() == length)
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints the n-length palindromes in the file. */
  
  public static void printPalindromes(String filename, int length) {
    try(Stream<String> words = Files.lines(Paths.get(filename))) {
      printPalindromes(words, length);
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
    }
  }
}
