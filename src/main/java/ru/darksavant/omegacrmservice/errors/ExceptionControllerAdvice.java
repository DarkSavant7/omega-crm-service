package ru.darksavant.omegacrmservice.errors;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleResourceNotFoundException(BadRequestException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = {AccessDeniedException.class})
    public ResponseEntity<CrmErrorDto> handleAccessDeniedException(AccessDeniedException e) {
        // 403
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.FORBIDDEN.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleNotEnoughPermissionsException(NotEnoughPermissionsException e) {
        // 403
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.FORBIDDEN.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleExpiredJwtException(ExpiredJwtException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleBusyTimeToRecordException(BusyTimeToRecordException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleBadDataRequestException(BadDataRequestException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleValidationException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<CrmErrorDto> handleStorageFileNotFound(StorageFileNotFoundException e) {
        log.error(e.getMessage());
        CrmErrorDto err = new CrmErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}
