package com.mywallet.financialmanager.repositories;

import com.mywallet.financialmanager.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {}
