package com.BudgetWise.BudgetWise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class transaction {
    @Id
    private Long id;
    private LocalDate transactionDate;
    private String category;
    private BigDecimal amount;
    private String description;
}
