package com.mywallet.financialmanager.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class DuplicatedEmailException extends RuntimeException {
  private final String name = "DuplicatedEmailException";
  private final HttpStatus status = HttpStatus.CONFLICT;

  public DuplicatedEmailException(String message) {
    super(message);
  }
}
