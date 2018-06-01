public class UrlChecker {
  public static void main(String[] args) {
    String url = "http://www.whitehouse.gov/issues/technology/";
    // Above is good URL; below is bad one. Or try several from the command line
    // String url = "http://www.whitehouse.gov/issues/technology/alchemy.html";
    if (args.length > 0) {
      url = args[0];
    }
    UrlParser parser = new UrlParser(url);
    UriChecker checker = 
      new UriChecker(parser.getHost(), parser.getPort(), 
                     parser.getUri());
    checker.connect();
  }
}