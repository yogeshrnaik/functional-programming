package coreservlets;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.*;

public class WebUtils {
  public static Stream<String> lines(String address) {
    try {
      URL url = new URL(address);
      BufferedReader in = 
        new BufferedReader(new InputStreamReader(url.openStream()));
      return(in.lines());
    } catch(IOException ioe) { 
      System.err.println(ioe);
      return(Stream.empty()); // Similar to Stream.of() with no arguments
    }
  }
  
  /** Sends standard HTTP response line, response headers, and top of a standard Web page.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
  public static void printHeader(PrintWriter out, String serverName) {
    out.println
      ("HTTP/1.1 200 OK\r\n" +
       "Server: " + serverName + "\r\n" +
       "Content-Type: text/html\r\n" +
       "\r\n" +
       "<!DOCTYPE html>\n" +
       "<html lang=\"en\">\n" +
       "<head>\n" +
       "  <meta charset=\"utf-8\"/>\n" +
       "  <title>" + serverName + " Results</title>\n" +
       "</head>\n" +
       "\n" +
       "<body bgcolor=\"#fdf5e6\">\n" +
       "<h1 align=\"center\">" + serverName +
         " Results</h1>\n" +
       "Here are the request line and request headers\n" +
       "sent by your browser:\n" +
       "<pre>");
  }

  /** Sends bottom of a standard Web page.
   *  <p>
   *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
   *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
   *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
   *  servlets, JSP, and Java 7 and Java 8 programming</a>.
   */
  public static void printTrailer(PrintWriter out) {
    out.println("</pre></body></html>\n");
  }

  /** Gets the POST line. 
   *  Normal Web page requests use GET, so this server can simply
   *  read a line at a time. However, HTML forms can also use
   *  POST, in which case we have to read one extra line.
   *  (This server does not support multipart/form-data.)
   */
  public static boolean isUsingPost(List<String> inputs) {
    return(inputs.get(0).toUpperCase().startsWith("POST"));
  }

  /** POST submissions have one extra line at the end, after the blank line,
   *  and NOT terminated by CR. Ignore multi-line posts, such as file uploads.
   *  Also assume no more than 1000 characters.
   */
  public static String postData(BufferedReader in) throws IOException {
    char[] data = new char[1000];
    int chars = in.read(data);
    return(new String(data, 0, chars));
  }

  private WebUtils() {} // Uninstantiatable class: static methods only
}
