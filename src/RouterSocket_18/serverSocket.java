package RouterSocket_18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverSocket {

	public static void main(String[] args) throws IOException{
		try(ServerSocket serverSocket = new ServerSocket(9189);
			Socket socket1 = serverSocket.accept()){	
			//InputStream input = socket1.getInputStream();
			Scanner scanner = new Scanner(socket1.getInputStream());
			//OutputStream output = socket1.getOutputStream();
			PrintWriter pWritter = new PrintWriter(socket1.getOutputStream(), true);
			//pWritter.println("Hello. U send me: ");
				while(scanner.hasNextLine()) {
					String string = scanner.nextLine();
					pWritter.println("U have send: "+string);
					System.out.println(string);
					if(string.equals("exit")) {
						break;
					}
				}
		}
	}

}
