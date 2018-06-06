package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.CommentBean;

public interface CommentRepository extends CrudRepository<CommentBean, String> {

}
