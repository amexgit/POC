package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ApproverNotFoundException;
import com.cts.exception.TicketUpdateException;
import com.cts.model.TicketBean;
import com.cts.service.ApproverService;
import com.cts.vo.TicketVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApproverController {
	
	ApproverService appService;
	
	public ApproverController(ApproverService appService) {
		log.debug("ApproverController : constructor");
		this.appService = appService;
	}
	
	@GetMapping(value = "/amex/tickets/view/{approverId}")
	public ResponseEntity<List<TicketBean>> viewTickets(@PathVariable("approverId") String approverId) {
		log.debug("viewTickets invoked : approverID = "+approverId);
		Optional<List<TicketBean>> tb = appService.viewTickets(approverId);
		log.debug("after viewTickets" + tb);
		
		if(!tb.isPresent()) {
			throw new ApproverNotFoundException("No approver with "+approverId +" found");
		}		
		return new ResponseEntity<>(tb.get(),HttpStatus.OK);		
	}

	@PutMapping(value = "/amex/tickets/update")
	public ResponseEntity<String> updateProcess(@RequestBody TicketVO ticket) {
		log.debug("updateProcess invoked"+ticket.getApproverId() + "request body"+ticket);
		
		Optional<TicketBean> tb = appService.updateStatus(ticket);
		if(tb.isPresent()) {		
		return new ResponseEntity<>("Success",HttpStatus.OK);
		}else {
			throw new TicketUpdateException("Ticket Not Updated");
		}
	}
}
