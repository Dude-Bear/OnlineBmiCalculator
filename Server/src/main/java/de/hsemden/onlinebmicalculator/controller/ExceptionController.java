package de.hsemden.onlinebmicalculator.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
            ConstraintViolationException.class
    })
    public ResponseEntity<List<String>> handleBadRequestExceptions(Exception e) {
        final List<String> errors = new ArrayList<>();

        Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();

        String error;
        for (ConstraintViolation constraintViolation : constraintViolations) {
            error = constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage();
            errors.add(error);
        }


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        String error;

        Object value = e.getValue();
        if (value == "") {
            String variable = e.getName();
            error = "Variable \"" + variable + "\" cannot be empty.";
        } else {
            error = "Variable input \"" + value + "\" is invalid. The input must be an integer.";
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * Behandelt alle verbleibenden Exceptions und gibt den HTTP Status Code 500 (Internal Server Error) zurück.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleInternalServerErrorExceptions(Exception ex) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
