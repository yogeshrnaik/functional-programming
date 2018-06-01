/** ShapeUtils.sumArea(someShapeArray) returns the sum of the areas of the shapes.
 *  It might also be reasonable to put this static method in the Shape class, but if so,
 *  it should be called via Shape.sumAreas(...), not someShapeInstance.sumAreas(...).
 *  Interfaces in Java 8 are the perfect solution, since they allow static methods, but
 *  enforce that the static methods are called via the class name, not using an
 *  instance.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ShapeUtils {
  public static double sumAreas(Shape[] shapes) {
    double sum = 0;
    for(Shape s: shapes) {
      sum = sum + s.getArea();
    }
    return(sum);
  }
  
  private ShapeUtils() {}
}
