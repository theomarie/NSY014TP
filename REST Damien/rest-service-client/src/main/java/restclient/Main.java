package restclient;

import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		String endpoint = "http://localhost:8080/sendMessage";
		String message = "coucou!";
		
		Request request = new Request(endpoint, message); 
		
		String getResponse = request.sendMessage("GET");
		String postResponse = request.sendMessage("POST");
		
		System.out.println("\n");
		System.out.println("Réponse du serveur avec méthode GET : " + "\n" + getResponse + "\n");
		System.out.println("Réponse du serveur avec méthode POST : " + "\n" + postResponse+ "\n");
	}
}