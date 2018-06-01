import java.net.*;
import java.io.*;

/** Connects to a server and receives an array of shapes.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ShapeClient {
  public ShapeClient(String host, int port) {
    try(Socket client = new Socket(host, port);
        ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {
      Shape[] shapes = (Shape[])in.readObject();
      System.out.println("Received array with sum of areas: " +
                         ShapeUtils.sumAreas(shapes));
    } catch(IOException ioe) {
      System.out.println("Error reading socket: " + ioe);
    } catch(ClassNotFoundException cnfe) {
      System.out.println("No such class: " + cnfe);
    }
  }

  public static void main(String[] args) {
    String host = "localhost";
    int port = 8888;
    if (args.length > 1) {
      try {
        host = args[0];
        port = Integer.parseInt(args[1]);
      } catch(NumberFormatException nfe) {}
    }
    new ShapeClient(host, port);
  }
}