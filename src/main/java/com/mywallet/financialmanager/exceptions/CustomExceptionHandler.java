package com.mywallet.financialmanager.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(DuplicatedEmailException.class)
  public ResponseEntity<Object> handleDuplicatedEmailException(DuplicatedEmailException ex, WebRequest req) {
    ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getName(), ex.getMessage());

    return handleExceptionInternal(ex, exceptionDetails, new HttpHeaders(), ex.getStatus(), req);
  }

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException ex, WebRequest req) {
    ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getName(), ex.getMessage());

    return handleExceptionInternal(ex, exceptionDetails, new HttpHeaders(), ex.getStatus(), req);
  }
}
