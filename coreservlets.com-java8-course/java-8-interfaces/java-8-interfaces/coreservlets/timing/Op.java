package coreservlets.timing;

/** Represents an operation that we will want to time. 
 *  Added a static and default method to the interface
 *  that we had used earlier.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

@FunctionalInterface
public interface Op {
  static final double ONE_BILLION = 1_000_000_000;
  
  void runOp();
  
  static void timeOp(Op operation) {
    long startTime = System.nanoTime();
    operation.runOp();
    long endTime = System.nanoTime();
    double elapsedSeconds = (endTime - startTime)/ONE_BILLION;
    System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
  }
  
  default Op combinedOp(Op secondOp) {
    return(() -> { runOp();
                   secondOp.runOp(); });
  }
}
