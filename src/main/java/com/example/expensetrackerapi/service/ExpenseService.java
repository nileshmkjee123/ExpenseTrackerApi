package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.model.Expense;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
//import java.util.List;

public interface ExpenseService {
   public List<Expense> findAllExpenses();
  public  Expense getExpenseById(Long id);

  public Expense createExpense(Expense expense);
  public String deleteExpense(Long id);
  public Expense updateExpense(Long id, Expense expense);
}
