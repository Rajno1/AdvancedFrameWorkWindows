package com.issi.exceptions;

public class InvalidConfigPathException extends FrameWorkExceptions{
    public InvalidConfigPathException(String message) {
        super(message);
    }

    public InvalidConfigPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConfigPathException(Throwable cause) {
        super(cause);
    }
}
