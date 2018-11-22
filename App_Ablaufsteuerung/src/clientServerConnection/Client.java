package clientServerConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			socket = new Socket(host,port);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(
					socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(
					new InputStreamReader(System.in));
			String msg = in.readLine();
			System.out.println(msg);
			String line;
			while(true) {
				line = input.readLine();
				if(line == null || line.equals("q"))
					break;
				out.println(line);
				System.out.println(in.readLine());
			}
			in.close();
			out.close();
			input.close();
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
}
