import java.net.*;
import java.io.*;

public class ShowFtpMessage extends NetworkClient {
  public ShowFtpMessage(String host) {
    super(host, 21);
  }

  @Override
  protected void handleConnection(Socket client)
    throws IOException {
    BufferedReader in = SocketUtils.getReader(client);
    System.out.println("Welcome message: " + in.readLine());
    client.close();
  }

  public static void main(String[] args) {
    String host = "ftp.cisco.com";
    if (args.length > 0) {
      host = args[0];
    }
    ShowFtpMessage client = new ShowFtpMessage(host);
    client.connect();
  }
}