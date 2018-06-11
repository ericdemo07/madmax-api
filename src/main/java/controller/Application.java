package controller;

import controller.handler.DefaultHandler;
import controller.handler.FileUploadHandler;
import controller.handler.RequestValidatorFilter;
import ratpack.server.RatpackServer;

public class Application {

    public static void main(String[] args) throws Exception {


        RatpackServer.start(
                server -> server
                        .handlers(chain -> chain
                                .all(new RequestValidatorFilter())
                                .get(ctx -> new DefaultHandler().handle(ctx))
                                .get("data/employees", ctx -> new DefaultHandler().employeeDataHandle(ctx))
                                .post("upload", new FileUploadHandler())
                                .get(":name", ctx -> new DefaultHandler().nameHandle(ctx))
                                .post("sum/:amount", ctx -> new DefaultHandler().postAmountHandle(ctx))));
    }
}