package com.alibha;

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
        // TODO: implement application
    }

}
