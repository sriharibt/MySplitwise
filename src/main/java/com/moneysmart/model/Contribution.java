package com.moneysmart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Contribution {
    private String contributionID;
    private double contributionValue;
    private String transactionID;
    private String transactionDescription;
    private LocalDateTime contributionTime;

}
