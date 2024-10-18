import java.io.*;
import java.net.*;

public class ClientUDP {
	public static void main(String[] args) {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("Adresse du client : " + addr.getHostName());
			String s = "Hello World";
			byte[] data = s.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
			DatagramSocket sock = new DatagramSocket();
			sock.send(packet);

			byte[] buffer = new byte[1024];
			DatagramPacket response = new DatagramPacket(buffer, buffer.length);
			sock.receive(response);

			String received = new String(response.getData(), 0, response.getLength());
			System.out.println("Réponse du serveur : " + received);

			sock.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
