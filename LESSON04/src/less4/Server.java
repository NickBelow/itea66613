package less4;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread {
	Socket s;
	int num;
	
	public Server( int num,Socket s) {
		this.s = s;
		this.num = num;
		setDaemon(true);
		start();
	}

	public static void main(String[] args) {
		try {
			int connections=0;
			ServerSocket server=
new ServerSocket(3134, 0, 
		InetAddress.getByName("192.168.1.250"));
		System.out.println("Server is started...");
		while(true) {
			new Server(++connections,server.accept());
			System.out.println("Connections: "+connections);
		}		} catch (UnknownHostException e) {	} catch (IOException e) {	}	
	}
	@Override
	public void run() {
		try {
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			byte[] buf=new byte[64*1024];
			int r=is.read(buf);
			String data=new String(buf,0,r);
			System.out.println("Accepted: "+data);
			data="Hello from server!";
			os.write(data.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}