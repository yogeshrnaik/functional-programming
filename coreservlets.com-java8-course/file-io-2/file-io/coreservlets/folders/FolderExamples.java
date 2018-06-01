package coreservlets.folders;

/** Some examples of exploring folders and searching for files.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
public class FolderExamples {
  public static void main(String[] args) {
    //listExamples();
    //walkExamples();
    findExamples();
  }
  
  public static void listExamples() {
    System.out.println("All files in project root");
    FolderUtils.printAllPathsInFolder(".");
    System.out.println("Text files in project root");
    FolderUtils.printPathsInFolder(".", 
                                p -> p.toString().endsWith(".txt"));
  }
  
  public static void walkExamples() {
    System.out.println("All files under project root");
    FolderUtils.printAllPathsInTree(".");
    System.out.println("Java files under project root");
    FolderUtils.printPathsInTree(".", 
                            p -> p.toString().endsWith(".java"));
  }
  
  public static void findExamples() {
    System.out.println("Java files under project root");
    FolderUtils.findPathsInTree(".", 
        (path,attrs) -> path.toString().endsWith(".java"));
    System.out.println("Folders under project root");
    FolderUtils.findPathsInTree(".", 
        (path,attrs) -> attrs.isDirectory());
    System.out.println("Large files under project root");
    FolderUtils.findPathsInTree(".", 
        (path,attrs) -> attrs.size() > 10000);
  }
}
