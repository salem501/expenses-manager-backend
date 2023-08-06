package com.BudgetWise.BudgetWise.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false, updatable = false)
    private UUID userId;
    private LocalDate transactionDate;
    private String category;
    private BigDecimal amount;
    private String description;
}
