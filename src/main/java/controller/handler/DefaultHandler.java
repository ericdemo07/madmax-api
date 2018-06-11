package controller.handler;

import controller.Employee;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import java.util.ArrayList;
import java.util.List;

public class DefaultHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("Welcome to my app");
    }

    public void employeeDataHandle(Context ctx) throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1L, "Mr", "John Doe"));
        employees.add(new Employee(2L, "Mr", "White Snow"));

        ctx.render(Jackson.json(employees));
    }

    public void nameHandle(Context ctx) throws Exception {
        ctx.render("Hello " + ctx.getPathTokens().get("name") + "!!!");
    }

    public void postAmountHandle(Context ctx) throws Exception {
        ctx.render(" Amount $" + ctx.getPathTokens().get("amount") + " added successfully !!!");
    }
}
