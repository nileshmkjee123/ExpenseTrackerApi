package com.example.expensetrackerapi.controller;

import com.example.expensetrackerapi.model.Expense;
import com.example.expensetrackerapi.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ExpenseController {
private ExpenseService expenseService;
    @GetMapping("/hi")
    public String hi()
    {
        return "hello";
    }

    @GetMapping("/expenses")
    public List<Expense> findAllExpenses()
    {
        return expenseService.findAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long expenseId)
    {
        return expenseService.getExpenseById(expenseId);
    }

    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense)
    {
       expenseService.createExpense(expense);
       return expense;
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@PathVariable("id") Long expenseId,@RequestBody Expense expense)
    {
        return expenseService.updateExpense(expenseId,expense);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteById(@PathVariable("id") Long expenseId)
    {
        return expenseService.deleteExpense(expenseId);
    }
}
