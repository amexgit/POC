package com.cts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(ApproverNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(ApproverNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
}
