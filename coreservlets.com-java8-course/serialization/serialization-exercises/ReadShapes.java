import java.io.*;

/** Reads previously stored shapes from a file.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ReadShapes {
  public static Shape[] readShapesFromFile(String filename) {
    try(FileInputStream fileIn = new FileInputStream(new File(filename));
        ObjectInputStream in = new ObjectInputStream(fileIn)) {
      Shape[] shapes = (Shape[])in.readObject();
      return(shapes);
    } catch(IOException ioe) {
      System.out.println("Error reading file: " + ioe);
    } catch(ClassNotFoundException cnfe) {
      System.out.println("No such class: " + cnfe);
    }
    return(null);
  }

  public static void main(String[] args) {
    String filename = "Shapes.ser";
    if (args.length > 0) {
      filename = args[0];
    }
    Shape[] shapes = readShapesFromFile(filename);
    System.out.println("Read array with sum of areas: " +
                       ShapeUtils.sumAreas(shapes));
  }
}