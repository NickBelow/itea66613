package less4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Client {
	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		for(;;) {
		try {
			Socket s=new Socket(
InetAddress.getByName("192.168.1.175"), 3134);
			System.out.println("¬ведите сообщение: ");
			String sms;
			sms = SCANNER.nextLine();
			String data= sms;
			s.getOutputStream().write(data.getBytes());
			byte[] buf=new byte[64*1024];
			int r=s.getInputStream().read(buf);
			 data=new String(buf,0,r);
			System.out.println("Server: "+data);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}}