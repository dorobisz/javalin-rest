package app;

import io.javalin.Javalin;
import pd.rest.api.CustomerController;
import pd.rest.repository.CustomerRepository;

import static io.javalin.apibuilder.ApiBuilder.crud;
import static io.javalin.apibuilder.ApiBuilder.put;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

        Javalin app = Javalin.create().start(7777);
        app.routes(() -> {
            CustomerController usersHandler = new CustomerController(customerRepository);

            crud("/customer/:id", usersHandler);
            put("/customer/:id", ctx -> usersHandler.update(ctx, ctx.pathParam("id")));

        });

        app.get("/", ctx -> ctx.result("prosty rest do przechowywania klientów"));
    }

}