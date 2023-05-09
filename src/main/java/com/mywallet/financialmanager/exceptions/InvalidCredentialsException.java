package com.mywallet.financialmanager.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class InvalidCredentialsException extends RuntimeException {
  private final String name = "InvalidCredentialsException";
  private final HttpStatus status = HttpStatus.UNAUTHORIZED;

  public InvalidCredentialsException(String message) { super(message); }
}
