package ConnectionTry;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*; 
import java.net.*; 

public class TCPServer 
{
    public static void main(String argv[]) throws Exception 
    {
       String clientSentence;
       String capitalizedSentence;
       ServerSocket welcomeSocket = new ServerSocket(6789);
       while(true)
       {
           Socket connectionSocket = welcomeSocket.accept(); 
           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
           DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
           clientSentence = inFromClient.readLine();
           capitalizedSentence = clientSentence.toUpperCase() + '\n';
           outToClient.writeBytes(capitalizedSentence); 
           connectionSocket.close();
         //  welcomeSocket.close();
        }
     }
}
