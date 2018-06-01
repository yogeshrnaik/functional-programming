import java.net.*;
import java.io.*;

/** Connects to the NumServer and shows the result.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ShowNumber extends NetworkClient {
  public ShowNumber(String host, int port) {
    super(host, port);
  }

  @Override
  protected void handleConnection(Socket client)
    throws IOException {
    BufferedReader in = SocketUtils.getReader(client);
    System.out.println("Number: " + in.readLine());
    client.close();
  }

  public static void main(String[] args) {
    String host = "localhost";
    int port = 8088;
    if (args.length > 0) {
      host = args[0];
    }
    if (args.length > 1) {
      port = Integer.parseInt(args[1]);
    }
    ShowNumber client = new ShowNumber(host, port);
    client.connect();
  }


}