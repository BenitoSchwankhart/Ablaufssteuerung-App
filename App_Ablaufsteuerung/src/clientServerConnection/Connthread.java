package clientServerConnection;

	import java.io.*;
	import java.net.*;

	public class Connthread
	implements Runnable {
	int i;
	String host;
	public Connthread(String host, int i) {
	this.i = i;
	this.host = host;
	}
	 
	public void run() {
	try {
	Socket target = new Socket(host, i);
	System.err.println("Connected to " + host + " on Port " + i);
	target.close();
	}
	catch (UnknownHostException ex) {
	System.out.println("Unkown Host " + host);
	}
	catch (IOException ex) {
	}
	}
} 

