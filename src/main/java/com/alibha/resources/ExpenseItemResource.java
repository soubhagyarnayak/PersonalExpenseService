package com.alibha.resources;

import com.alibha.api.ExpenseItem;
import com.alibha.db.ExpenseItemRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseItemResource {
    private ExpenseItemRepository expenseItemRepository;

    @GET
    @Path("/{id}")
    public ExpenseItem getById(@PathParam("id") Long id){
        return expenseItemRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(ExpenseItem expenseItem){
        expenseItemRepository.save(expenseItem);
    }

    public ExpenseItemResource(ExpenseItemRepository expenseItemRepository){
        this.expenseItemRepository = expenseItemRepository;
    }
}
