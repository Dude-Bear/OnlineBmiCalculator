package de.hsemden.onlinebmicalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    /**
     * Behandelt MethodArgumentNotValidException und ConstraintViolationException Exceptions, welche in
     * einem HTTP Status Code 400 (Bad Request) resultieren. Erstellt eine Liste von Fehlermeldungen
     * und gibt diese zurück.
     *
     * @param e MethodArgumentNotValidException oder ConstraintViolationException
     * @return HTTP Status Code 400 mit einer Liste von Validierungsfehlern
     */
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public ResponseEntity<List<String>> handleBadRequestExceptions(Exception e) {
        final List<String> errors = new ArrayList<>();

        if (e instanceof MethodArgumentNotValidException) {
            // Es können mehrere FieldErrors gleichzeitig auftreten - für jeden wird eine Fehlernachricht hinzugefügt
            ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors().forEach(fieldError -> {
                errors.add(fieldError.getField() + " -> " + fieldError.getDefaultMessage());
            });
        } else {
            errors.add(e.getMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Behandelt alle verbleibenden Exceptions und gibt den HTTP Status Code 500 (Internal Server Error) zurück.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleInternalServerErrorExceptions(Exception ex) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
