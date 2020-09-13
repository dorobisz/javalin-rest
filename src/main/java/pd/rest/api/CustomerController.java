package pd.rest.api;

import java.util.Optional;

import pd.rest.Customer;
import pd.rest.repository.CustomerRepository;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;

public class CustomerController implements CrudHandler {

    private CustomerRepository users;

    public CustomerController(CustomerRepository users) {
        this.users = users;
    }

    @Override
    public void create(Context ctx) {
        var user = ctx.bodyAsClass(Customer.class);
        var newUser = users.save(user);
        ctx.json(newUser);
        ctx.status(201);
    }

    @Override
    public void delete(Context ctx, String id) {
        users.delete(Integer.valueOf(id));
        ctx.status(204);
    }

    @Override
    public void getAll(Context ctx) {
        ctx.json(users.findAll());
    }

    @Override
    public void getOne(Context ctx, String id) {
        Optional<Customer> user = users.findById(Integer.valueOf(id));
        handleOptionalResponse(ctx, user);
    }

    private void handleOptionalResponse(Context ctx, Optional<Customer> user) {
        user.map(ctx::json)
                .orElse(ctx.status(404));
    }

    @Override
    public void update(Context ctx, String id) {
        var user = ctx.bodyAsClass(Customer.class);
        users.update(Integer.valueOf(id), user);
        ctx.status(204);
    }

}