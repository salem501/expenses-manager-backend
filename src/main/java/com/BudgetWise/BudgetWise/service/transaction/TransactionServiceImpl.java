package com.BudgetWise.BudgetWise.service.transaction;

import com.BudgetWise.BudgetWise.entity.transaction.Transaction;
import com.BudgetWise.BudgetWise.repository.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Optional<Transaction> findTransactionById(UUID transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public List<Transaction> findAllTransactionsByUserId(UUID userId) {
        return transactionRepository.findAllTransactionsByUserId(userId);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(UUID id) {
        transactionRepository.deleteTransactionById(id);
    }

    public Transaction updateTransaction(Transaction transaction) {
        transactionRepository.deleteTransactionById(transaction.getId());
        return transactionRepository.save(transaction);
    }
}