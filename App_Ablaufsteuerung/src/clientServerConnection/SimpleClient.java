package clientServerConnection;

import java.io.*;
import java.net.*;

public class SimpleClient {
	
	public static void main(String[] args) {
		String a = "Hallo Server";
		try {
			Socket s = new Socket("141.58.220.192",9090);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF(a);
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
