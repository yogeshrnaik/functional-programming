package coreservlets.writefiles;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/** Writes to a file from a List in one fell swoop. Works in either
 *  Java 7 or Java 8, unlike the file reading examples that used
 *  Files.lines, which work only in Java 8.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class WriteFile1 {
  public static void main(String[] args) throws IOException {
    Charset characterSet = Charset.defaultCharset();
    Path path = Paths.get("output-file-1.txt");
    List<String> lines = 
      Arrays.asList("Line One", "Line Two", "Final Line");
    Files.write(path, lines, characterSet);
  }
}
