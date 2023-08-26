package com.BudgetWise.BudgetWise.repository.transaction;

import com.BudgetWise.BudgetWise.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.userId = :userId")
    List<Transaction> findAllTransactionsByUserId(@Param("userId") UUID userId);

    void deleteTransactionById(UUID id);

    Optional<Transaction> findById(UUID transactionId);
}