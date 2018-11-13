package clientServerConnection;

public class PortScanner1 {
	public static void main(String[] args) {
	String host = args[0];
	for (int i = 0; i < 20000; i++) {
	Connthread curr = new Connthread(host, i);
	Thread th = new Thread(curr);
	th.start();
	try {
	th.sleep(1);
	}
	catch (InterruptedException ex) {
	}
	}
	}

}
