import java.io.*;
import java.net.*;

public class ServeurTCP3 {
	public static void main(String[] args) {
		try {
			ServerSocket socketserver = new ServerSocket(2016);
			System.out.println("Serveur en attente de connexion...");
			while (true) {
				Socket socket = socketserver.accept();
				System.out.println("Connexion d'un client.");
				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
				String message = dIn.readUTF();
				System.out.println("Message reçu : " + message);
				String reversedMessage = new StringBuilder(message).reverse().toString();
				dOut.writeUTF(reversedMessage);
				dIn.close();
				dOut.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

