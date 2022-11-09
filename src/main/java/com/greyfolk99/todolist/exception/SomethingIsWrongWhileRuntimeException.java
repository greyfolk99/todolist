package com.greyfolk99.todolist.exception;

public class SomethingIsWrongWhileRuntimeException extends RuntimeException{
    public SomethingIsWrongWhileRuntimeException(String message) {
        super(message);
    }
    public SomethingIsWrongWhileRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
