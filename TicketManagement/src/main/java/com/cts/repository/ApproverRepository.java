package com.cts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.ApproverBean;

@Repository
public interface ApproverRepository extends CrudRepository<ApproverBean, String> {

	Optional<ApproverBean> findByApproverId(String approverId);
}
