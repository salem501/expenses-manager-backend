package com.BudgetWise.templates.service.transaction;

import com.BudgetWise.templates.entity.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface TransactionService {
    List<Transaction> findAllTransactionsByYearAndMonthAndUserId(UUID userId, int year, int month);
    Transaction addTransaction(Transaction transaction);
}
