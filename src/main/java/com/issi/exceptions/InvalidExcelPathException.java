package com.issi.exceptions;

public class InvalidExcelPathException extends FrameWorkExceptions{
    public InvalidExcelPathException(String message) {
        super(message);
    }

    public InvalidExcelPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExcelPathException(Throwable cause) {
        super(cause);
    }
}
