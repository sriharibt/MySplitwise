package com.moneysmart.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private String id;
    private String userId;
    private String expense;
    private String description;
    private LocalDateTime expenseDate;
    private ExpenseStatus expenseStatus;
    private double expenseAmount;
    private ExpenseGroup expenseGroup;
}
