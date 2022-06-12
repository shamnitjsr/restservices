package com.nitjsr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nitjsr.entity.Expense;

public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);
	Expense getExpenseById(Long id);
	void deleteById(Long id);
	Expense saveExpenseDetails(Expense expense);
	Expense updateExpenseDetails(Long id, Expense expense);
}
