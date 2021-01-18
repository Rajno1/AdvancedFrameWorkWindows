package com.issi.exceptions;

public class FrameWorkExceptions extends RuntimeException{
    public FrameWorkExceptions(String message) {
        super(message);
    }

    public FrameWorkExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameWorkExceptions(Throwable cause) {
        super(cause);
    }
}
