package com.example.expensetrackerapi.controller;

import com.example.expensetrackerapi.model.Expense;
import com.example.expensetrackerapi.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class ExpenseController {
private ExpenseService expenseService;
    @GetMapping("/hi")
    public String hi()
    {
       calculate(1);

        return "hello";
    }
int calculate(int n)
{
    return n*calculate(n-1);
}
    @GetMapping("/expenses")
    public Page<Expense> findAllExpenses(Pageable pageable)
    {
        return expenseService.findAllExpenses(pageable);
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

    @GetMapping("/expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String
                                              category,Pageable page)
    {
       return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getExpenseByNameKeyword(@RequestParam String
                                                             name,Pageable page)
    {
        return expenseService.readByNameContaining(name, page);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getExpenseByDate(@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date
                                                         endDate, Pageable page)
    {
        return expenseService.readByDateBetween(startDate,endDate, page);
    }
}
