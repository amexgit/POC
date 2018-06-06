package com.cts.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name = "Comment")
@NoArgsConstructor
public class CommentBean implements Serializable{

	private static final long serialVersionUID = -8947337877654821430L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long commentId;
	
	private String comment;
	
	private Timestamp lastUpdateDate;
	
	@ManyToOne
	@NonNull
	private TicketBean ticket;
	
	private String status;
}
