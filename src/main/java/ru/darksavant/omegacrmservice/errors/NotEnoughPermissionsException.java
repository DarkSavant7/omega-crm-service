package ru.darksavant.omegacrmservice.errors;

public class NotEnoughPermissionsException extends RuntimeException{
    public NotEnoughPermissionsException(String message) {
        super(message);
    }
}
