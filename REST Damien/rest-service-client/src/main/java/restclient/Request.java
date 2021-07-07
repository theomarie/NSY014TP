package restclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request 
{
	String endpoint;
	String message;
	
	public Request(String endpoint, String message)
	{
		this.endpoint = endpoint;
		this.message = message;
	}
	
	/**
	 * Send message with either POST or GET request
	 * @param method
	 * @return
	 * @throws IOException
	 */
	public String sendMessage(String method) throws IOException
	{
		if (message.length() == 0)
		{
			return "Vous devez renseigner un message";
		}
		
		if (method == "GET")
		{
			return this.sendGet(this.getEndpoint());
		}
		else if(method == "POST")
		{
			return this.sendPost(this.getEndpoint());
		}
		else
		{
			return "Methode invalide";
		}
	}
	
	/**
	 * Send a POST request to specified endpoint
	 * @param endpoint
	 * @return
	 * @throws IOException
	 */
	private String sendPost(String endpoint) throws IOException 
	{
		URL obj = new URL(endpoint);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json"); // response format

		String jsonInputString = "{\n \"content\": \" " + this.getMessage() + " \"\n}";

		// Sending data post
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(jsonInputString.getBytes());
		os.flush();
		os.close();
		// Sending data end

		int responseCode = con.getResponseCode();
		// System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) //success 
		{ 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) 
			{
				response.append(inputLine);
			}
			
			in.close();

			return(response.toString());
		} 
		else 
		{
			return("POST request not worked");
		}
	}
	
	/**
	 * Send a POST request to specified endpoint
	 * @param endpoint
	 * @return
	 * @throws IOException
	 */
	public String sendGet(String endpoint) throws IOException 
	{
		String url = endpoint + "?message=" + this.getMessage();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		
		// System.out.println("GET Response Code :: " + responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) // success 
		{ 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) 
			{
				response.append(inputLine);
			}
			
			in.close();
			
			return response.toString();
		} 
		else 
		{
			return "GET request not worked";
		}
	}

	
	/** GETTERS AND SETTERS **/
	
	/**
	 * Get message
	 * @return
	 */
	public String getMessage()
	{
		return this.message;
	}
	
	/**
	 * Get endpoint
	 * @return
	 */
	public String getEndpoint()
	{
		return this.endpoint;
	}
}
