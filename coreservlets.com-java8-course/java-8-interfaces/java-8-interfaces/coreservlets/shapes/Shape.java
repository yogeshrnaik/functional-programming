package coreservlets.shapes;

/** Represents the parent of all shapes that have a getArea method.
 *  This (using an interface) is the third attempt at a design that will support 
 *  making a static method to sum the areas of a mixed set of shapes. This approach is 
 *  better than the second approach (using an abstract class) in two ways: because classes
 *  can implement more than one interface, and because with static methods in interfaces
 *  Java enforces that you call them via InterfaceName.staticMethodName(...), whereas with
 *  static methods in abstract classes it is possible to call them via instanceName.staticMethodName(...),
 *  which misleads readers of the code into thinking that they are normal instance methods
 *  instead of static methods. General rule in Java 8 and later: use interfaces instead of abstract
 *  classes except for the relatively rare case where you need to define instance variables
 *  in the abstract class.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public interface Shape {
  double getArea(); // All real shapes must define a getArea 
  
  public static double sumAreas(Shape[] shapes) {
    double sum = 0;
    for(Shape s: shapes) {
      sum = sum + s.getArea();
    }
    return(sum);
  }
}