package com.nitjsr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nitjsr.entity.Expense;
import com.nitjsr.exceptions.ResourceNotFoundException;
import com.nitjsr.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {

		return expenseRepository.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {

		Optional<Expense> expense = expenseRepository.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense is not found for the id:::" + id);
	}

	@Override
	public void deleteById(Long id) {

		expenseRepository.deleteById(id);

	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {

		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense exitingExpense = getExpenseById(id);
		exitingExpense.setName(expense.getName() != null ? expense.getName() : exitingExpense.getName());
		exitingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : exitingExpense.getDescription());
		exitingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : exitingExpense.getCategory());
		exitingExpense.setDate(expense.getDate() != null ? expense.getDate() : exitingExpense.getDate());
		exitingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : exitingExpense.getAmount());
		return expenseRepository.save(expense);
		
	}

}
