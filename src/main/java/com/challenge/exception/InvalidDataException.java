package com.challenge.exception;

public class InvalidDataException extends RuntimeException {
	private Long id;
	private String message = "Please provide valid data.";
	
	public InvalidDataException() {
		super();
	}

	public String getMessage() {
		return this.message;
	}
}
