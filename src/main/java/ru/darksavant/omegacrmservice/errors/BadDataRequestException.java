package ru.darksavant.omegacrmservice.errors;

public class BadDataRequestException extends RuntimeException{
    public BadDataRequestException(String message) {
        super(message);
    }
}
