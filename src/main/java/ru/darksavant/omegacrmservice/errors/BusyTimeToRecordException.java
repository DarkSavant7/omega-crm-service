package ru.darksavant.omegacrmservice.errors;

public class BusyTimeToRecordException extends RuntimeException {
    public BusyTimeToRecordException(String message) {
        super(message);
    }
}
