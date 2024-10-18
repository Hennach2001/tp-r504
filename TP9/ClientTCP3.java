import java.io.*;
import java.net.*;

public class ClientTCP3
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("Veuillez fournir un message en argument.");
			return;
		}
		try {
			Socket socket = new Socket("localhost", 2016);
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
			dOut.writeUTF(args[0]);
			System.out.println("Message envoyé : " + args[0]);
			dOut.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

