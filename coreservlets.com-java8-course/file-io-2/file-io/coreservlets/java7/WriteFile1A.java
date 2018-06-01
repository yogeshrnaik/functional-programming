package coreservlets.java7;

import java.io.*;
import java.util.*;

public class WriteFile1A {
  public static void main(String[] args) throws IOException {
    List<String> lines = 
      Arrays.asList("Line One", "Line Two", "Final Line");
    FileUtils.writeLines("OutputFile1.txt", lines);
  }
}
