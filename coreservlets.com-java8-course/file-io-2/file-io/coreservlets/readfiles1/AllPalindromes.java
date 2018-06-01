package coreservlets.readfiles1;

import java.nio.file.*;
import coreservlets.strings.*;

/** Prints all palindromes. Uses the first, simplest, and least flexible
 *  file-reading variation, where code is placed directly in "main".
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java). Java 9 topics coming soon.</a>.
 */

public class AllPalindromes {
  public static void main(String[] args) throws Exception {
    String inputFile = "enable1-word-list.txt";
    Files.lines(Paths.get(inputFile))
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
}
