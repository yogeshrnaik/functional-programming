import java.net.*;
import java.io.*;

public class UriChecker extends NetworkClient {
  private String uri;

  public static void main(String[] args) {
    UriChecker checker
      = new UriChecker(args[0], Integer.parseInt(args[1]),
                       args[2]);
    checker.connect();
  }

  public UriChecker(String host, int port, String uri) {
    super(host, port);
    this.uri = uri;
  }

  @Override
  protected void handleConnection(Socket uriSocket)
      throws IOException {
    PrintWriter out = SocketUtils.getWriter(uriSocket);
    BufferedReader in = SocketUtils.getReader(uriSocket);
    out.printf("HEAD %s HTTP/1.1\r\n", uri);
    out.printf("Host: %s\r\n", getHost());
    out.printf("Connection: close\r\n\r\n");
    String line = in.readLine();
    System.out.printf("Result: %s.%n", line);
  }
}