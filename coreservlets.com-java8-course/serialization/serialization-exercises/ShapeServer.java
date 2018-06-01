import java.net.*;
import java.io.*;

/** Sends an array of shapes to whomever connects.
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

public class ShapeServer {
  public ShapeServer(int port, int numShapes) {
    listen(port, numShapes);
  }

  @SuppressWarnings("resource")
  public void listen(int port, int numShapes) {
    try(ServerSocket listener = new ServerSocket(port);) {
      Socket server;
      while(true) {
        server = listener.accept();
        Shape[] shapes = StoreShapes.getRandomShapes(numShapes);
        System.out.println("Sending array with sum of areas: " +
                            ShapeUtils.sumAreas(shapes));
        ObjectOutputStream out =
          new ObjectOutputStream(server.getOutputStream());
        out.writeObject(shapes);
        out.close();
      }
    } catch (IOException ioe) {
      System.out.println("IOException: " + ioe);
      ioe.printStackTrace();
    }
  }

  public static void main(String[] args) {
    int port = 8888;
    int numShapes = 25;
    if (args.length > 1) {
      try {
        port = Integer.parseInt(args[0]);
        numShapes = Integer.parseInt(args[1]);
      } catch(NumberFormatException nfe) {}
    }
    new ShapeServer(port, numShapes);
  }
}