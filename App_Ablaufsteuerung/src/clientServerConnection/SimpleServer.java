package clientServerConnection;

import java.io.*;
import java.net.*;

public class SimpleServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9090);
			Socket s = ss.accept(); //**makes connection possible
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			System.out.println("Client says" + str);
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
