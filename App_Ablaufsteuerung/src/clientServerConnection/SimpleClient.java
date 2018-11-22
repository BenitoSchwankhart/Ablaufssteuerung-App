package clientServerConnection;

import java.io.*;
import java.net.*;

public class SimpleClient {
	
	public static void main(String[] args) {
		try {
			Socket s = new Socket("141.58.218.183",9090);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hallo Server");
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
