package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.exception.ExpenseNotFoundException;
import com.example.expensetrackerapi.model.Expense;
import com.example.expensetrackerapi.repository.ExpenseRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private ExpenseRepository expenseRepository;
    @Override
    public Page<Expense> findAllExpenses(Pageable pageable) {

        return  expenseRepository.findAll(pageable);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent())
        {
            return expense.get();
        }
        throw new ExpenseNotFoundException("Expense not found for id "+id);
    }

    @Override
    public Expense createExpense(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public String deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        return "Expense "+id+" is deleted";
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense updatedEmployee = expenseRepository.findById(id).get();
        updatedEmployee.setName(expense.getName());
        updatedEmployee.setDescription(expense.getDescription());
        updatedEmployee.setAmount(expense.getAmount());
        updatedEmployee.setDate(expense.getDate());
        updatedEmployee.setCategory(expense.getCategory());
        expenseRepository.save(updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable page) {
        return expenseRepository.findByCategory(category,page).toList();
    }

    @Override
    public List<Expense> readByNameContaining(String keyword, Pageable page) {
        return expenseRepository.findByNameContaining(keyword,page).toList();
    }

    @Override
    public List<Expense> readByDateBetween(Date startDate, Date endDate, Pageable page) {
        if(startDate == null)
            startDate = new Date(0);
        if(endDate == null)
            endDate = new Date(System.currentTimeMillis());
        return expenseRepository.findByDateBetween(startDate,endDate,page).toList();
    }


}
