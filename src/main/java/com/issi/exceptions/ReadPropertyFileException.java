package com.issi.exceptions;

public class ReadPropertyFileException extends FrameWorkExceptions{
    public ReadPropertyFileException(String message) {
        super(message);
    }

    public ReadPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadPropertyFileException(Throwable cause) {
        super(cause);
    }
}
