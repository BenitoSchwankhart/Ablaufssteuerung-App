package clientServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port;
	private int backlog;
	
	public Server(int port, int backlog) {
		this.port = port;
		this.backlog = backlog;
	}
	
	public void startServer() {
		try {
			ServerSocket server = new ServerSocket(port, backlog);
			
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("Server auf " + addr.getHostName() + "/" + addr.getHostAddress()
			+ ":" + port + "gestartet...");
			
			process(server);
		}
		catch (IOException e) {
			System.err.println(e);
			
		}
	}
	private void process(ServerSocket server) throws IOException{
		while (true) {
			Socket client = server.accept();
			
			String clientAddr = client.getInetAddress().getHostAddress();
			int clientPort = client.getPort();
			System.out.println("Verbindung zu " + clientAddr + ":" + clientPort + " aufgebaut");
			
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				
				out.println("Server ist bereit ...");
				
				String input;
				while((input = in.readLine()) != null) {
					out.println(input);
				}
				in.close();
				out.close();
			}
			catch (IOException e) {
			}
			System.out.println("Verbindung zu " + clientAddr + ":" + clientPort + "abgebaut");
		}
	}


public static void main(String[] args) {
	if(args.length != 1 && args.length != 2) {
		System.err.println("java Server <port> [<backlog>]");
		System.exit(1);
	}
	
	int port = Integer.parseInt(args[0]);
	int backlog = 50;
	
	if(args.length == 2) {
		backlog = Integer.parseInt(args[1]);
		
		new Server(port, backlog).startServer();
	}
}
}