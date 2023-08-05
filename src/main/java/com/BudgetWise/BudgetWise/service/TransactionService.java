package com.BudgetWise.BudgetWise.service;

import com.BudgetWise.BudgetWise.entity.Transaction;
import com.BudgetWise.BudgetWise.entity.User;
import com.BudgetWise.BudgetWise.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAllTransactionsByUser(User user) {
        return transactionRepository.findAllByUserId(user.getId());
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
    }
}