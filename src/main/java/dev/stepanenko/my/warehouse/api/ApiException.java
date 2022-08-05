package dev.stepanenko.my.warehouse.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")

public class ApiException extends RuntimeException{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
