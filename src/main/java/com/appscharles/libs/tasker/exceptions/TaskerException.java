package com.appscharles.libs.tasker.exceptions;

/**
 * The type Tasker exception.
 */
public class TaskerException extends Exception {

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 3271375823223120122L;

    /**
     * Instantiates a new Tasker exception.
     */
    public TaskerException() {
        super();
    }

    /**
     * Instantiates a new Tasker exception.
     *
     * @param message the message
     */
    public TaskerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Tasker exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TaskerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Tasker exception.
     *
     * @param cause the cause
     */
    public TaskerException(Throwable cause) {
        super(cause);
    }

}

