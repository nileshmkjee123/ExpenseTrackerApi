package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface ExpenseService {
   public Page<Expense> findAllExpenses(Pageable pageable);
  public  Expense getExpenseById(Long id);

  public Expense createExpense(Expense expense);
  public String deleteExpense(Long id);
  public Expense updateExpense(Long id, Expense expense);

  List<Expense> readByCategory(String category, Pageable page);
  List<Expense> readByNameContaining(String keyword, Pageable page);
  List<Expense> readByDateBetween(Date startDate, Date endDate, Pageable page);
}
