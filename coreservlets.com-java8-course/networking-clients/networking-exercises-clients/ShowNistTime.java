import java.net.*;
import java.io.*;

public class ShowNistTime extends NetworkClient {
  public ShowNistTime(String host, int port) {
    super(host, port);
  }

  @Override
  protected void handleConnection(Socket client)
    throws IOException {
    BufferedReader in = SocketUtils.getReader(client);
    in.readLine();  // Ignore leading blank line
    System.out.println("Time: " + in.readLine());
    client.close();
  }

  public static void main(String[] args) {
    String host = "time-c.nist.gov";
    int port = 13;
    if (args.length > 0) {
      host = args[0];
    }
    if (args.length > 1) {
      port = Integer.parseInt(args[1]);
    }
    ShowNistTime client = new ShowNistTime(host, port);
    client.connect();
  }
}