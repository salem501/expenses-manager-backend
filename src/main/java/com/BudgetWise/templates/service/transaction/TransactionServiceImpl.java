package com.BudgetWise.templates.service.transaction;

import com.BudgetWise.templates.entity.transaction.Transaction;
import com.BudgetWise.templates.repository.transaction.TransactionRepository;
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

    public List<Transaction> findAllTransactionsByYearAndMonthAndUserId(UUID userId, int year, int month) {
        return transactionRepository.findAllTransactionsByYearAndMonth(userId, year, month);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(UUID id) {
        transactionRepository.deleteById(id);
    }

    public Transaction updateTransaction(UUID id, Transaction transaction) {
        Optional<Transaction> transactionToUpdate = transactionRepository.findById(id);
        if (transactionToUpdate.isPresent()) {
            transactionToUpdate.get().setCategory(transaction.getCategory());
            transactionToUpdate.get().setAmount(transaction.getAmount());
            transactionToUpdate.get().setTransactionDate(transaction.getTransactionDate());
            transactionToUpdate.get().setDescription(transaction.getDescription());
            return transactionToUpdate.get();
        }
        throw new RuntimeException("transaction not found");
    }
}