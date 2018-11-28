package clientServerConnection;

import java.net.*;
import java.io.*;

public class client {
public static void main(String[] args) throws UnknownHostException, IOException {
    Socket s = new Socket("localhost",5555);
    
  PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String msg;
  while((msg=br.readLine())!=null)
  {
      System.out.println("Sending "+msg);
      pw.println(msg);
  }
  }
}