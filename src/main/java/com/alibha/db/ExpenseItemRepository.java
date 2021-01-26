package com.alibha.db;

import com.alibha.api.ExpenseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseItemRepository {
    private ExpenseItemDao expenseItemDao;

    public ExpenseItem findById(long id) {
        return expenseItemDao.findById(id);
    }

    public long save(ExpenseItem expenseItem){
        return expenseItemDao.insert(expenseItem);
    }

    public ExpenseItemRepository(ExpenseItemDao expenseItemDao){
        this.expenseItemDao = expenseItemDao;
    }
}
