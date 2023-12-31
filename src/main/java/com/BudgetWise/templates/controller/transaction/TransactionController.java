package com.BudgetWise.templates.controller.transaction;

import com.BudgetWise.templates.Dto.transaction.TransactionDto;
import com.BudgetWise.templates.entity.transaction.Transaction;
import com.BudgetWise.templates.service.transaction.TransactionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionServiceImpl transactionService;
    private final ModelMapper mapper;

    public TransactionController(TransactionServiceImpl transactionService, ModelMapper mapper) {
        this.transactionService = transactionService;
        this.mapper = mapper;
    }

    @GetMapping("/getByYearAndMonth/{userId}/{year}/{month}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUserAndYearAndMonth(@PathVariable("userId") UUID userId, @PathVariable("year") int year, @PathVariable("month") int month) {
        List<TransactionDto> allTransactions = transactionService.findAllTransactionsByYearAndMonthAndUserId(userId, year, month)
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

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<Transaction> updateTransaction(@PathVariable UUID id, @RequestBody Transaction transaction) {
        System.out.println(1);
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        Optional<Transaction> transactionOptional = transactionService.findTransactionById(id);

        if (transactionOptional.isPresent()) {
            transactionService.deleteTransaction(transactionOptional.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}