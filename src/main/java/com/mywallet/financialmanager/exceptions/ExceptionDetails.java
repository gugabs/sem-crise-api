package com.mywallet.financialmanager.exceptions;

import lombok.Getter;

@Getter

public class ExceptionDetails {
  private String details = "[%s] %s";

  public ExceptionDetails(String name, String description) {
    this.details = String.format(this.details, name, description);
  }
}
