package com.BudgetWise.BudgetWise.controller.transaction;

import com.BudgetWise.BudgetWise.Dto.transaction.TransactionDto;
import com.BudgetWise.BudgetWise.entity.transaction.Transaction;
import com.BudgetWise.BudgetWise.service.transaction.TransactionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionServiceImpl transactionService;
    private final ModelMapper mapper;

    public TransactionController(TransactionServiceImpl transactionService, ModelMapper mapper) {
        this.transactionService = transactionService;
        this.mapper = mapper;
    }

    @GetMapping("/find/{userId}")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(@PathVariable("userId") UUID userId) {
        List<TransactionDto> allTransactions = transactionService.findAllTransactionsByUserId(userId)
                .stream()
                .map(transaction -> mapper.map(transaction,TransactionDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(allTransactions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteTransaction(@PathVariable UUID id) {
        Optional<Transaction> transactionOptional = transactionService.findTransactionById(id);

        if (transactionOptional.isPresent()) {
            transactionService.deleteTransaction(transactionOptional.get().getId());
            return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
        }
    }
}