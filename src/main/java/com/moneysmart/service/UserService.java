package com.moneysmart.service;

import com.moneysmart.model.*;
import com.moneysmart.repository.ExpenseRepository;
import com.moneysmart.repository.UserRepository;

public class UserService {

    public User createUser(String emailId, String name, String phoneNumber) {
        User user = new User(name, emailId, phoneNumber);
        UserRepository.userHashMap.putIfAbsent(emailId, user);
        return user;
    }

    public void contributeToExpense(String expenseID, String emailId, Contribution contribution)

    throws InvalidExpenseState, ExpenseSettledExcpetion, ContributionExceededException
    {

        Expense expense = ExpenseRepository.expenseMap.get(expenseID);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();

        if (expense.getExpenseStatus() == ExpenseStatus.CREATED) {
            throw new InvalidExpenseState("Invalid expense state");
        }

        if (expense.getExpenseStatus() == ExpenseStatus.SETTLED) {
            throw new  ExpenseSettledExcpetion("Expense already settled");
        }

        UserShare userShare = expenseGroup.getUserContributions().get(emailId);

        if (contribution.getContributionValue() > userShare.getShare()) {
            thow new ContributionExceededException();
        }

        userShare.getContributionsList().add(contribution);





    }



}
