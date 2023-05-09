package com.mywallet.financialmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull(message = "E-mail cannot be null")
  @NotBlank(message = "E-mail cannot be blank")
  @Email
  private String email;

  @NotNull(message = "Password cannot be null")
  @NotBlank(message = "Password cannot be blank")
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Transaction> transactions;
}
