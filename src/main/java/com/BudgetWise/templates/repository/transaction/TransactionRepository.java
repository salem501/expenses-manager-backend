package com.BudgetWise.templates.repository.transaction;

import com.BudgetWise.templates.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("select t from Transaction t where t.userId = :userId AND year(t.transactionDate) = :year AND month(t.transactionDate) = :month")
    List<Transaction> findAllTransactionsByYearAndMonth(@Param("userId") UUID userId, @Param("year") int year, @Param("month") int month);

}