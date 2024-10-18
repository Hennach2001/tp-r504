import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Veuillez fournir un message à envoyer.");
            return;
        }

        try {
            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dIn = new DataInputStream(socket.getInputStream());


            dOut.writeUTF(args[0]);


            String response = dIn.readUTF();
            System.out.println("Réponse du serveur : " + response);

            dOut.close();
            dIn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

