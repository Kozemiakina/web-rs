package com.kazhamiakina.model.DAO.Exception;

/**
 * Created by alisa on 22.01.2017.
 */

public class DAOException extends Exception {
    private ExceptionTrace exceptionTrace = new ExceptionTrace();

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public ExceptionTrace getExceptionTrace() {
        exceptionTrace.setTrace(getStringFromTrace(getStackTrace()));
        return exceptionTrace;
    }

    private String getStringFromTrace(StackTraceElement[] stackTrace) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (StackTraceElement element : stackTrace) {
            builder.append(String.valueOf(element)).append("\n");
        }
        return builder.toString();
    }
}
