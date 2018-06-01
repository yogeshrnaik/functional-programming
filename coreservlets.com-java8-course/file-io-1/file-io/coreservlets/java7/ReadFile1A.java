package coreservlets.java7;

import java.util.List;

/** Similar to ReadFile1, but uses a method from FileUtils to simplify the code. 
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class ReadFile1A {
  public static void main(String[] args) throws Exception {
    String file = "input-file.txt";
    List<String> lines = FileUtils.getLines(file);
    System.out.printf("Lines from %s: %s%n", file, lines);
  }
}
