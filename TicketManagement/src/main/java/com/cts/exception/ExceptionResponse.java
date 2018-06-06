package com.cts.exception;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ExceptionResponse {
  private LocalDateTime timestamp;
  private String message;
  private String details;

  public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }

}