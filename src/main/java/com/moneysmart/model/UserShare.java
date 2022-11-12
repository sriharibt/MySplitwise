package com.moneysmart.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserShare {

    private String userID;
    private Double share;
    List<Contribution> contributionsList;

    public UserShare(String userID, double share) {
        this.userID = userID;
        this.share = share;
        contributionsList = new ArrayList<>();
    }


}
