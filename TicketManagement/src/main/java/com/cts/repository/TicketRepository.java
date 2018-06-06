package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.TicketBean;

@Repository
public interface TicketRepository extends CrudRepository<TicketBean, String> {

	Optional<List<TicketBean>> findByApproverId(String approverId);
	
	Optional<TicketBean> findByTicketId(String ticketId);
}
