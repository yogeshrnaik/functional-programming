package coreservlets;

import javax.swing.*;

/** This parses the input to get a host, port, and uri (file), then
 *  passes these three values to the UriRetriever class to
 *  grab the URL from the Web.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class UrlRetriever {
  public static void main(String[] args) {
    String defaultAddress = "http://docs.oracle.com/javase/8/docs/";
    String address = JOptionPane.showInputDialog("URL:", defaultAddress);
    if (address == null) {
      address = defaultAddress;
    }
    UrlParser parser = new UrlParser(address);
    UriRetriever uriClient = 
      new UriRetriever(parser.getHost(), parser.getPort(), parser.getUri());
    uriClient.connect();
  }
}