package coreservlets.folders;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.function.*;
import java.util.stream.*;

/** Some Stream-based static methods for using with folders and paths.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class FolderUtils {
  public static void printAllPaths(Stream<Path> paths) {
    paths.forEach(System.out::println);
  }
  
  public static void printAllPathsInFolder(String folder) {
    try(Stream<Path> paths = Files.list(Paths.get(folder))) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printPaths(Stream<Path> paths, Predicate<Path> test) {
    paths.filter(test)
         .forEach(System.out::println);
  }
  
  public static void printPathsInFolder(String folder, Predicate<Path> test) {
    try(Stream<Path> paths = Files.list(Paths.get(folder))) {
      printPaths(paths, test);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printAllPathsInTree(String rootFolder) {
    try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void printPathsInTree(String rootFolder, Predicate<Path> test) {
    try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
      printPaths(paths, test);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  public static void findPathsInTree(String rootFolder, BiPredicate<Path,BasicFileAttributes> test) {
    try(Stream<Path> paths = Files.find(Paths.get(rootFolder), 10, test)) {
      printAllPaths(paths);
    } catch(IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  private FolderUtils() {} // Uninstantiatable class
}
