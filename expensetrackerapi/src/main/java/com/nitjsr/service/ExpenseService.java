package com.nitjsr.service;

import java.util.List;

import com.nitjsr.entity.Expense;

public interface ExpenseService {

	List<Expense> getAllExpenses();
	Expense getExpenseById(Long id);
	void deleteById(Long id);
	Expense saveExpenseDetails(Expense expense);
	Expense updateExpenseDetails(Long id, Expense expense);
}
