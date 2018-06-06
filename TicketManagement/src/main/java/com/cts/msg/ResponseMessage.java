package com.cts.msg;

import com.cts.model.ApproverBean;

import lombok.Data;

@Data
public class ResponseMessage {

	private String message;
	private ApproverBean approver;
}
