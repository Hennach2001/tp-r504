import java.io.*;
import java.net.*;

public class ClientTCP1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

            dOut.writeUTF("message test");
