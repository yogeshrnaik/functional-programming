import java.net.*;
import java.io.*;

/** Sends data to the SumServer, then shows the result.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ShowSum extends NetworkClient {
  private double d1, d2;

  public ShowSum(String host, int port,
                 double d1, double d2) {
    super(host, port);
    this.d1 = d1;
    this.d2 = d2;
  }

  @Override
  protected void handleConnection(Socket client)
      throws IOException {
    PrintWriter out = SocketUtils.getWriter(client);
    BufferedReader in = SocketUtils.getReader(client);
    out.println(d1);
    out.println(d2);
    System.out.printf("Sum of %s and %s is %s.%n",
                      d1, d2, in.readLine());
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
    double d1 = Math.random();
    double d2 = Math.random();
    if (args.length > 3) {
      d1 = Double.parseDouble(args[2]);
      d2 = Double.parseDouble(args[3]);
    }
    ShowSum client = new ShowSum(host, port, d1, d2);
    client.connect();
  }


}