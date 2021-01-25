package com.alibha;

import com.alibha.db.ExpenseItemRepository;
import com.alibha.resources.ExpenseItemResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PersonalExpenseServiceApplication extends Application<PersonalExpenseServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PersonalExpenseServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "PersonalExpenseService";
    }

    @Override
    public void initialize(final Bootstrap<PersonalExpenseServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PersonalExpenseServiceConfiguration configuration,
                    final Environment environment) {
        ExpenseItemRepository expenseItemRepository = new ExpenseItemRepository();
        ExpenseItemResource expenseItemResource = new ExpenseItemResource(expenseItemRepository);
        environment.jersey().register(expenseItemResource);
    }

}
