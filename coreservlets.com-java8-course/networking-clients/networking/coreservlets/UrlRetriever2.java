package coreservlets;

import javax.swing.*;

/** Read a remote file using the standard URL class
 *  instead of connecting explicitly to the HTTP server.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class UrlRetriever2 {
  public static void main(String[] args) {
    String defaultAddress = "http://docs.oracle.com/javase/8/docs/";
    String address = JOptionPane.showInputDialog("URL:", defaultAddress);
    if (address == null) {
      address = defaultAddress;
    }
    WebUtils.lines(address).forEach(System.out::println);
  }
}