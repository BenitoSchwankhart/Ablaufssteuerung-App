package clientServerConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static void main (String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(555);
	    System.out.println("Server is now up and running...");
	    
	    while(true)
	    {
	      Socket s = ss.accept();
	      new thread(s).start();
	    }
	  }

}
