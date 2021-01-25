package com.alibha.db;

import com.alibha.api.ExpenseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseItemRepository {
    private List<ExpenseItem> expenseItems;

    public Optional<ExpenseItem> findById(long id) {
        return expenseItems.stream()
                .filter(expenseItem -> expenseItem.getId()==id)
                .findFirst();
    }

    public void save(ExpenseItem expenseItem){
        expenseItems.add(expenseItem);
    }

    public ExpenseItemRepository(){
        this.expenseItems = new ArrayList<>();
    }
}
