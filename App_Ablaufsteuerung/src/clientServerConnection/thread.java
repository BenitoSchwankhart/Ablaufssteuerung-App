package clientServerConnection;

import java.net.*;
import java.io.*;

public class thread extends Thread{
  public Socket s;
  
  public thread(Socket s)
  {
    this.s=s;
  }
  
  public void run()
  {
    BufferedReader br;
    try {
    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    
    String client_msg = null;
    while((client_msg=br.readLine())!=null)
    {
      System.out.println("The client sent : "+client_msg);
    }
    
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
