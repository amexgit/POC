package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketUpdateException extends RuntimeException {

	private static final long serialVersionUID = 276229689355783756L;

	public TicketUpdateException(String message) {
		super(message);
	}

	
}
