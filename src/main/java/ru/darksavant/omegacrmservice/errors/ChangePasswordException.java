package ru.darksavant.omegacrmservice.errors;

public class ChangePasswordException extends RuntimeException {
    public ChangePasswordException(String message) {
        super(message);
    }

    public ChangePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
