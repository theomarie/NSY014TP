package com.example.restservice;

import java.time.LocalDate;

public class Message 
{
	private long id;
	private final String content;
	private LocalDate date; 

	public Message(long id, String content)
	{
		this.id = id;
		this.content = content;
		this.date = java.time.LocalDate.now();
	}
	
	/** GETTER AND SETTERS */
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getContent()
	{
		return this.content;
	}
	
	public String getDate()
	{
		return this.date.toString();
	}
	
	public String display()
	{
		return "(" + this.getDate() + ") \"" + this.getContent() + "\", ID : " + this.getId();
	}
}
