import java.net.*;
import java.io.*;

class Server{
  static BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[ ] args){
  try{
		int MAX_LEN = 10;
		System.out.println("Enter the port number : ");
	
		int localPortNum = Integer.parseInt(ob.readLine());
		DatagramSocket mySocket = new DatagramSocket(localPortNum);

		DatagramPacket packet ;
		int buff=0;
		while(true)
		{

			byte[] buffer = new byte[MAX_LEN];
			packet = new DatagramPacket(buffer, MAX_LEN);
			mySocket.receive(packet);
			String message = new String(buffer);
			System.out.println(message);
			buff++;
			if(buff==10)
				break;
		}
		mySocket.close( );
	}
	catch(Exception e){e.printStackTrace( );}
	}
}
