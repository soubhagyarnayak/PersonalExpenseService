package com.alibha.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ExpenseItem {
    private long id;
    private DateTime timestamp;
    private String category;
    private String recipient;
    private String description;
    private double amount;
    private String tags;
}