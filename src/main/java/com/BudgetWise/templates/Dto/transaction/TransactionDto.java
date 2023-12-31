package com.BudgetWise.templates.Dto.transaction;

import com.BudgetWise.templates.entity.transaction.TransactionType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto implements Serializable {
    @NonNull
    private UUID id;
    @NonNull
    private LocalDate transactionDate;
    @NonNull
    private String category;
    @NonNull
    private BigDecimal amount;

    private String description;

    private TransactionType type;
}
