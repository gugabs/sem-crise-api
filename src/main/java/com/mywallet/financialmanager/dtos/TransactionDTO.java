package com.mywallet.financialmanager.dtos;

import com.mywallet.financialmanager.enums.TransactionTypeEnum;

import java.math.BigDecimal;

public record TransactionDTO(TransactionTypeEnum type, BigDecimal value, String description, Integer ownerId) {}
