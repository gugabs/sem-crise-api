package com.mywallet.financialmanager.controllers;

import com.mywallet.financialmanager.dtos.TransactionDTO;
import com.mywallet.financialmanager.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @PostMapping("/transaction")
  @ResponseStatus(HttpStatus.CREATED)
  public void createTransaction(@RequestBody TransactionDTO transaction) {
    this.transactionService.createTransaction(transaction);
  }
}
