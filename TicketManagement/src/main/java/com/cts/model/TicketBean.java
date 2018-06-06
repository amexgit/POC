package com.cts.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data @NoArgsConstructor @ToString
@Entity
@Table(name = "Ticket")
public class TicketBean implements Serializable{

	private static final long serialVersionUID = -1643049692891835549L;
	
	@Id
	private String ticketId;
	
	@NonNull
	private String requestorId;
	
	@NonNull
	private String approverId;	
	
	@NonNull
	private Timestamp dateOfCreation;
	
	@NonNull
	private Timestamp lastUpdateDate;
	
	@NonNull
	private String title;
	
	@NonNull
	private String priority;
	
	@NonNull
	private String category;
	
	@NonNull
	private String status;
	
	private String description;
	
	@ManyToOne
	private ApproverBean approver;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
	private Set<CommentBean> comment;
	
	/*
	@NonNull
	private String requestorEmail;
	
	@NonNull
	private String approverName;
	
	@NonNull
	private String approverEmail;*/	
	//private ArrayList<String> emailList;
	
} 