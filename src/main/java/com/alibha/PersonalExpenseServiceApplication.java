package com.alibha;

import com.alibha.db.ExpenseItemDao;
import com.alibha.db.ExpenseItemRepository;
import com.alibha.resources.ExpenseItemResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

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
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final ExpenseItemDao expenseItemDao = jdbi.onDemand(ExpenseItemDao.class);

        ExpenseItemRepository expenseItemRepository = new ExpenseItemRepository(expenseItemDao);
        ExpenseItemResource expenseItemResource = new ExpenseItemResource(expenseItemRepository);
        environment.jersey().register(expenseItemResource);
    }

}
