package com.BudgetWise.BudgetWise.service;

import com.BudgetWise.BudgetWise.entity.Transaction;
import com.BudgetWise.BudgetWise.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAllTransactionsByUserId(UUID userId) {
        return transactionRepository.findAllTransactionsByUserId(userId);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        transactionRepository.deleteTransactionById(transaction.getId());
        return transactionRepository.save(transaction);
    }
}