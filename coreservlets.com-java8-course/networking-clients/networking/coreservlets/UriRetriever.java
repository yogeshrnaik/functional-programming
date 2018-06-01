package coreservlets;
import java.net.*;
import java.io.*;

/** Retrieve a URL given the host, port, and file as three
 *  separate command-line arguments. A later class
 *  (UrlRetriever) supports a single URL instead.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class UriRetriever extends NetworkClient {
  private String uri;

  public static void main(String[] args) {
    UriRetriever retriever =
      new UriRetriever(args[0], Integer.parseInt(args[1]),
                       args[2]);
    retriever.connect();
  }

  public UriRetriever(String host, int port,
                      String uri) {
    super(host, port);
    this.uri = uri;
  }

  /** Send one GET line, then read the results one line at a
   *  time, printing each to standard output.
   */

  // It is safe to use in.lines() or loop and
  // do in.readLine() because Web servers close
  // the connection after sending the data. Send Host
  // to support virtual hosting servers, and send
  // Connection to be sure server does not try to
  // use persistent connections and keep socket open.

  @Override
  protected void handleConnection(Socket client)
      throws IOException {
    PrintWriter out = SocketUtils.getWriter(client);
    BufferedReader in = SocketUtils.getReader(client);
    out.printf("GET %s HTTP/1.1\r\n", uri);
    out.printf("Host: %s\r\n", getHost());
    out.printf("Connection: close\r\n\r\n");
    in.lines().forEach(System.out::println);
  }
  
 // Java 7 version
  protected void handleConnectionOld(Socket client)
      throws IOException {
    PrintWriter out = SocketUtils.getWriter(client);
    BufferedReader in = SocketUtils.getReader(client);
    out.printf("GET %s HTTP/1.1\r\n", uri);
    out.printf("Host: %s\r\n", getHost());
    out.printf("Connection: close\r\n\r\n");
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(line);
    }
  }
}