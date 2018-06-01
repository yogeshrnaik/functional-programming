package coreservlets.java7;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

/** Reads from file into a List in one fell swoop. Uses
 *  the Java-7 approach with Files.readAllLines, which is much less efficient
 *  than the Java 8 approach with Files.lines. 
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class ReadFile1 {
  public static void main(String[] args) throws Exception {
    String file = "input-file.txt";
    Charset characterSet = Charset.defaultCharset();
    Path path = Paths.get(file);
    List<String> lines = Files.readAllLines(path, characterSet);
    System.out.printf("Lines from %s: %s%n", file, lines);
  }
}
