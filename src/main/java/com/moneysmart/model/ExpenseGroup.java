package com.moneysmart.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class ExpenseGroup {

    private String groupID;
    private Set<User> groupMembers;
    @Setter
    private Map<String, UserShare> userContributions;

    public ExpenseGroup() {
        this.groupID = UUID.randomUUID().toString();
        this.groupMembers = new HashSet<>();
        this.userContributions = new HashMap<String, UserShare>();
    }





}
