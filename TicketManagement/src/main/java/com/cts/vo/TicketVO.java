package com.cts.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TicketVO {

private String ticketId;
	
	private String requestorId;
	private String approverId;	
	private Timestamp dateOfCreation;
	private Timestamp lastUpdateDate;
	private String title;
	private String priority;	
	private String category;
	private String status;
	private String description;
	private String comment;
}
