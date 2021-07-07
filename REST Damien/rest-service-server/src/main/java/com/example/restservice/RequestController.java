package com.example.restservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController 
{
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Handling GET request from /sendMessage endpoint
	 * @param message
	 * @return
	 */
	@GetMapping("/sendMessage")
	public Map<String, String> sendMessage(@RequestParam(value="message", defaultValue = "") String message)
	{	
		HashMap<String, String> map = new HashMap<>();
		
		if (message.length() == 0)
		{
			System.out.println("Taille du message : " + message.length());
			map.put("Error", "Veuillez renseigner un message");
		}
		else
		{
			Message m = new Message(counter.incrementAndGet(), message.toString());
			map.put("Id", String.valueOf(m.getId()));
			map.put("Date", m.getDate());
			map.put("Message", m.getContent());	
		}
		
		return map;
	}
	
	/**
	 * Handling POST request from /sendMessage endpoint
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/sendMessage", consumes = "application/json", produces = "application/json")
	public Message sendPost(@RequestBody Message message) 
	{
		message.setId(counter.incrementAndGet());
		return message;
	}
}