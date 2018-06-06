package com.cts.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Approver")
public class ApproverBean implements Serializable{

	private static final long serialVersionUID = 8068424164649648380L;
	
	@Id
	private String approverId;	
		
	private String name;
	
	private String emailId;
	
	private String supervisor;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "approver")
	private Set<TicketBean> ticket;
	
	//more fields to be added
}
