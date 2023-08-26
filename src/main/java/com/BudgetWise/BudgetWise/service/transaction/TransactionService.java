package com.BudgetWise.BudgetWise.service.transaction;

import com.BudgetWise.BudgetWise.entity.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface TransactionService {
    List<Transaction> findAllTransactionsByUserId(UUID userId);
    Transaction addTransaction(Transaction transaction);
}
