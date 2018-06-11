package controller.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.MutableHeaders;

public class RequestValidatorFilter implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        MutableHeaders headers = ctx.getResponse().getHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Accept-Language", "en-us");
        headers.set("Accept-Charset", "UTF-8");
        ctx.next();
    }
}
