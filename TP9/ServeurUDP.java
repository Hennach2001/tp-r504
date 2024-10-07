import java . io . * ;
import java . net . * ;

public class ServeurUDP
{
	public static void main( String[] args )
	{
		try
		{
			DatagramSocket stock = new DatagramSocket(1234);
			while(true)
			{
			Systeme.out.println("-Waiting data");
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			sock.recive(packet);
			String str = new String(packet.getData() );
			System.out.println("str="+str);
}
	}
		}
			}

