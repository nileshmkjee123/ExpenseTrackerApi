package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.model.Expense;
import com.example.expensetrackerapi.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private ExpenseRepository expenseRepository;
    @Override
    public List<Expense> findAllExpenses() {

        return  expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).get();
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


}
