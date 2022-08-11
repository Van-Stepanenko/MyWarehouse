package dev.stepanenko.my.warehouse.exception;

import dev.stepanenko.my.warehouse.api.ApiException;

public class BusinessException {
    public static class NameMatchException extends ApiException {
        private int code;
        public NameMatchException (int code, String msg) {
            super(code, msg);
            this.code = code;
        }
    }
}
