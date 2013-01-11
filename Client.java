import java.net.*;
import java.io.*;

class Client{
  static BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[ ] args){
	try{
		System.out.println("Enter the host name : ");
		InetAddress receiverHost = InetAddress.getByName(ob.readLine());
		
		System.out.println("Enter the port number : ");
		int receiverPort = Integer.parseInt(ob.readLine());
		DatagramSocket mySocket;
		int buff=0;
		while(true)
		{
			mySocket = new DatagramSocket( );
			System.out.print("Enter the message : ");
			String message = ob.readLine();
			buff++;
			if(buff==10)
				break;
			byte[] buffer = message.getBytes( );
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverHost,receiverPort);			
			mySocket.send(packet);
		}
		mySocket.close();
		}
	catch(Exception e){ e.printStackTrace( ); }
}
}
