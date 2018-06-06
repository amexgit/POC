package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.TicketBean;
import com.cts.service.TicketCreateService;

@RestController
public class TicketCreateController {
	
	TicketCreateService ticketCreateService;
		
	public TicketCreateController(TicketCreateService ticketCreateService) {
		super();
		this.ticketCreateService = ticketCreateService;
	}



	@PostMapping("/ticket")
	public ResponseEntity<TicketBean> createNewTicket(@RequestBody TicketBean ticketDto)
	{
		
		if(ticketDto!=null)
		{
			
			ticketCreateService.createTicket();
		return ResponseEntity.status(HttpStatus.CREATED).body(ticketDto);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

} 