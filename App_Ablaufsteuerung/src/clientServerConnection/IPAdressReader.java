package clientServerConnection;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPAdressReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Enumeration networkInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
		    	NetworkInterface networkInterface = (NetworkInterface) networkInterfaces
		    			.nextElement();
				System.out.println(networkInterface.getName() + ": "
		    			+ networkInterface.getInetAddresses().nextElement());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

