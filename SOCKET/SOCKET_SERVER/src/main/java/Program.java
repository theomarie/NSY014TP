import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Program {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public static void main(String[] args) {
		Program server = new Program();
		server.start(6666);
	}
	
	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new
					InputStreamReader(clientSocket.getInputStream()));
			String greeting = in.readLine();
			System.out.println(greeting);
			out.println("Hello client, c'est le serveur. Merci pour ton message : " + greeting);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
