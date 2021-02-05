package com.alibha.resources;

import com.alibha.api.ExpenseItem;
import com.alibha.db.ExpenseItemRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseItemResource {
    private ExpenseItemRepository expenseItemRepository;

    @GET
    @Path("/{id}")
    public ExpenseItem getById(@PathParam("id") Long id){
        return expenseItemRepository
                .findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ExpenseItem save(ExpenseItem expenseItem){
        long id = expenseItemRepository.save(expenseItem);
        expenseItem.setId(id);
        return expenseItem;
    }

    @GET
    @Path("/{year}/{month}")
    public List<ExpenseItem> getExpenseItemsForMonth(
            @PathParam("year") int year, @PathParam("month") int month){
        return expenseItemRepository.getExpenseItemsForMonth(year, month);
    }

    public ExpenseItemResource(ExpenseItemRepository expenseItemRepository){
        this.expenseItemRepository = expenseItemRepository;
    }
}
