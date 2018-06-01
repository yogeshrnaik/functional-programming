import java.net.*;
import java.io.*;

/** The base class retrieves a URL given the host, port, and file as three
 *  separate arguments, but main accepts a URL and splits it into the
 *  three pieces. Checks if any of the lines contain the specified word.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class StringChecker extends NetworkClient {
  private String host, uri;
  private String searchString;

  public StringChecker(String host, int port, String uri,
                       String searchString) {
    super(host, port);
    this.host = host;
    this.uri = uri;
    this.searchString = searchString;
  }

  @Override
  protected void handleConnection(Socket uriSocket)
      throws IOException {
    PrintWriter out = SocketUtils.getWriter(uriSocket);
    BufferedReader in = SocketUtils.getReader(uriSocket);
    out.printf("GET %s HTTP/1.1\r\n", uri);
    out.printf("Host: %s\r\n", getHost());
    out.printf("Connection: close\r\n\r\n");
    String line;
    boolean foundMatch = false;
    while ((line = in.readLine()) != null) {
      if (line.contains(searchString)) {
        System.out.println("Match: " + line);
        foundMatch = true;
      }
    }
    if (!foundMatch) {
      System.out.printf("Did not find '%s' in '%s' at '%s'.%n",
                        searchString, uri, host);
    }
  }
  
  public static void main(String[] args) {
    String url = "http://www.coreservlets.com/";
    String searchString = "Java";
    if (args.length > 0) {
      url = args[0];
    }
    if (args.length > 1) {
      searchString = args[1];
    }
    UrlParser parser = new UrlParser(url);
    StringChecker client
      = new StringChecker(parser.getHost(), parser.getPort(), 
                          parser.getUri(), searchString);
    client.connect();
  }
}