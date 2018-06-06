package com.cts.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cts.constants.TMConstants;
import com.cts.model.CommentBean;
import com.cts.model.TicketBean;
import com.cts.repository.ApproverRepository;
import com.cts.repository.CommentRepository;
import com.cts.repository.TicketRepository;
import com.cts.vo.TicketVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApproveServiceImpl implements ApproverService{
	
	ApproverRepository approverRepo;
	TicketRepository ticketRepo;
	CommentRepository commentRepo;	

	public ApproveServiceImpl(ApproverRepository approverRepo, TicketRepository ticketRepo,
			CommentRepository commentRepo) {
		this.approverRepo = approverRepo;
		this.ticketRepo = ticketRepo;
		this.commentRepo = commentRepo;
	}

	@Override
	@Transactional
	public Optional<TicketBean> updateStatus(TicketVO ticket) {
		log.debug("ApproveServiceImpl : approveStatus Approver"+ticket);
		Optional<TicketBean> ticketStatus = ticketRepo.findByTicketId(ticket.getTicketId());
		
		Timestamp time = Timestamp.valueOf(LocalDateTime.now());
		
		TicketBean ticketBean = new TicketBean();
		ticketBean.setApproverId(ticket.getApproverId());
		ticketBean.setTicketId(ticket.getTicketId());
		ticketBean.setLastUpdateDate(time);
		ticketBean.setStatus(TMConstants.STATUS_APPROVED);
		ticketBean.setTitle(ticket.getTitle());
		ticketBean.setCategory(ticket.getCategory());
		ticketBean.setDescription(ticket.getDescription());
		ticketBean.setRequestorId(ticket.getRequestorId());
		ticketRepo.save(ticketBean);
		
		
		CommentBean comment = new CommentBean();
		comment.setTicket(ticketBean);
		comment.setLastUpdateDate(time);
		comment.setStatus(TMConstants.STATUS_APPROVED);
		comment.setComment(ticket.getComment());
		commentRepo.save(comment);//Save Comment to DB
		 return Optional.of(ticketStatus.get());
	}

	@Override
	public Optional<List<TicketBean>> viewTickets(String approverId) {
		log.debug("ApproveServiceImpl viewTickets invoked with approverId = "+approverId);
		
		Optional<List<TicketBean>> tickets = ticketRepo.findByApproverId(approverId);
		
		if(tickets.isPresent()) {
			return tickets;
		}else {
		return Optional.empty();
		}
	}

}
