package com.ibm.ph.amperca.contacts.messages;

public class Message {
	
	private String status;
	private String type;
	private String message;
	
	public Message() {
		
	}
	
	public Message(String status, String type, String message) {
		this.status = status;
		this.type = type;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
