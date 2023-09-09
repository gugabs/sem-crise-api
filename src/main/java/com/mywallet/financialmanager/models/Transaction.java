package com.mywallet.financialmanager.models;

import com.mywallet.financialmanager.dtos.TransactionDTO;
import com.mywallet.financialmanager.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

@Entity
@Table(name = "transactions")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull(message = "Type cannot be null")
  private TransactionTypeEnum type;

  @NotNull(message = "Value cannot be null")
  private BigDecimal value;

  @Size(max = 256)
  private String description;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User owner;

  public Transaction() {}

  public Transaction(TransactionDTO transaction, User transactionOwner) {
    this.type = transaction.type();
    this.value = transaction.value();
    this.description = transaction.description();
    this.owner = transactionOwner;
  }
}
