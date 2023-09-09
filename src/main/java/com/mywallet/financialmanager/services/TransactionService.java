package com.mywallet.financialmanager.services;

import com.mywallet.financialmanager.dtos.TransactionDTO;
import com.mywallet.financialmanager.models.Transaction;
import com.mywallet.financialmanager.models.User;
import com.mywallet.financialmanager.repositories.TransactionRepository;
import com.mywallet.financialmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private UserRepository userRepository;

  public void createTransaction(TransactionDTO transaction) {
    User transactionOwner = userRepository.getReferenceById(transaction.ownerId());

    Transaction newTransaction = new Transaction(transaction, transactionOwner);
    this.transactionRepository.save(newTransaction);
  }
}
