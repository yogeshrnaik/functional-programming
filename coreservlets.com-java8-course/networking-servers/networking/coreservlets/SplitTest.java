package coreservlets;

/** Prints the tokens resulting from treating the first
 *  command-line argument as the string to be tokenized
 *  and the second as the delimiter set. Uses
 *  String.split instead of StringTokenizer.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class SplitTest {
  public static void main(String[] args) {
    if (args.length == 2) {
      String[] tokens = args[0].split(args[1]);
      for(String token: tokens) {
        if (token.length() != 0) {
          System.out.println(token);
        }
      }
    } else {
      System.out.println("Usage: java SplitTest string delimeters");
    }
  }
}