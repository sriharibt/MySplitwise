package com.moneysmart.model;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class User {
    private String name;
    private String userId;
    private String emailId;
    private String phoneNumber;


    public User(String name, String emailId, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.emailId = emailId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }





}