package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.TicketBean;
import com.cts.vo.TicketVO;

public interface ApproverService {
	
	public Optional<TicketBean> updateStatus(TicketVO ticket);

	public Optional<List<TicketBean>> viewTickets(String approverId);

}
