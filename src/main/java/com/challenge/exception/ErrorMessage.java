package com.challenge.exception;

public class ErrorMessage {
	private String message;
	private int status;
	
	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String message, int statusCode) {
		super();
		this.message = message;
		this.status = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
}
