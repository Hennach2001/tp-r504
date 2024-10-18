import java.io.*;
import java.net.*;

public class Clienthttp {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java ClientHttp <hostname>");
			return;
		}
		String hostname = args[0];
		Socket socket = null;
		try {
			socket = new Socket(hostname, 80);
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedWriter bufOut = new BufferedWriter(osw);
			BufferedReader bufIn = new BufferedReader(isr);
			String request = "GET / HTTP/1.0\r\nHost: " + hostname + "\r\n\r\n";
			bufOut.write(request);
			bufOut.flush();
			String line;
			while ((line = bufIn.readLine()) != null) {
				System.out.println(line);
			}
			bufIn.close();
			bufOut.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
				}
			}
		}


