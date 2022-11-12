package com.moneysmart.service;

import com.moneysmart.model.Expense;
import com.moneysmart.model.ExpenseGroup;
import com.moneysmart.model.ExpenseStatus;
import com.moneysmart.model.UserShare;
import com.moneysmart.repository.ExpenseRepository;
import com.moneysmart.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class ExpenseService {


    public Expense createExpense(String title,
                                 String description, LocalDateTime expenseDate, double expenseAmount,
                                 String userId, ExpenseStatus status) {

                Expense expense = Expense.builder().
                        id(UUID.randomUUID().toString())
                        .expenseAmount(expenseAmount)
                        .expenseDate(expenseDate)
                        .expenseGroup(new ExpenseGroup())
                        .userId(userId)
                        .expenseStatus(status)
                        .build();


        ExpenseRepository.expenseMap.putIfAbsent(expense.getId(), expense);
        return expense;
    }

    public void addUsersToExpense(String expenseId, String emailID) {

        if(!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            System.out.println("Create expense");
        }

        ExpenseRepository.expenseMap.get(expenseId).getExpenseGroup().getGroupMembers().add(UserRepository.userHashMap.get(emailID));

    }


    public void assignExpenseShare(String expenseId, String emailID, double share) {
        if(!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            System.out.println("Create expense");
        }

        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.getExpenseGroup()
                .getUserContributions().putIfAbsent(emailID, new UserShare(emailID, share));

    }

    public void setExpenseStatus(String expenseId, ExpenseStatus expenseStatus) {
        ExpenseRepository.expenseMap.get(expenseId).setExpenseStatus(expenseStatus);
    }

    public boolean isExpenseSettled(String expenseId) {
        Expense expense =ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        Map<String, UserShare> userContributions = expenseGroup.getUserContributions();

        double total = expense.getExpenseAmount();

    }



}