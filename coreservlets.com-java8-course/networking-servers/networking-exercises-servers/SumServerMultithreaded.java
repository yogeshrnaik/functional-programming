import java.net.*;
import java.io.*;

/** A multithreaded version of the server that takes two numbers and returns the sum.
 *  <p>
 *  The funny @SuppressWarnings annotation below is to tell Eclipse not to
 *  warn me that I could use try-with-resources (it use USUALLY results in
 *  more convenient code, but in this particular case, using it in handleConnection results
 *  in less-convenient code). For details on suppressing warnings, see
 *  http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftasks%2Ftask-suppress_warnings.htm
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */


public class SumServerMultithreaded extends MultithreadedServer{
  public static void main(String[] args) {
    int port = 8088;
    if (args.length > 0) {
      try {
        port = Integer.parseInt(args[0]);
      } catch(NumberFormatException nfe) {}
    }
    SumServerMultithreaded server = new SumServerMultithreaded(port);
    server.listen();
  }
  
  public SumServerMultithreaded(int port) {
    super(port);
  }
  
  @Override @SuppressWarnings("resource")
  public void handleConnection(Socket socket) throws IOException{
    PrintWriter out = SocketUtils.getWriter(socket);
    BufferedReader in = SocketUtils.getReader(socket);
    double num1 = 0;
    double num2 = 0;
    try {
      String line1 = in.readLine();
      num1 = Double.parseDouble(line1);
      String line2 = in.readLine();
      num2 = Double.parseDouble(line2);
    } catch(Exception e) {}
    out.println(num1 + num2);
    out.close();
  }
}