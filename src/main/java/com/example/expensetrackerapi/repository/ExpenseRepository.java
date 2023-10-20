package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
