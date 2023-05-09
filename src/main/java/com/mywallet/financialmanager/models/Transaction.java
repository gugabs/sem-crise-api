package com.mywallet.financialmanager.models;

import com.mywallet.financialmanager.enums.TransactionTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private TransactionTypeEnum type;

  private Float value;

  @ManyToOne
  private User user;
}
