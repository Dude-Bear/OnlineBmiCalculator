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
     * This ExceptionController handles ConstraintViolationExceptions.
     * Since multiple constraints can be violated at the same time,
     * a list of errors is created and returned.
     * The HTTP Status Code in the response is 400 (Bad Request).
     *
     *
     * @param e ConstraintViolationException
     * @return list of error messages and HTTP status code 400
     */
    @ExceptionHandler({
            ConstraintViolationException.class
    })
    public ResponseEntity<List<String>> handleBadRequestExceptions(Exception e) {
        //There can be multiple constrain violations at once
        final List<String> errors = new ArrayList<>();

        Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();

        String error;
        //Looping over all the constrain violations that have been detected
        for (ConstraintViolation constraintViolation : constraintViolations) {
            error = constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage();
            //Adding each error message to the error list
            errors.add(error);
        }


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * This ExceptionController handles MethodArgumentTypeMismatchExceptions.
     * The variables height and weight must both be integers.
     * If a wrong variable type or an empty value is sent, this Exception Controller will handle the exception.
     * The HTTP Status Code in the response is 400 (Bad Request).
     *
     *
     * @param e MethodArgumentTypeMismatchException
     * @return HTTP status code 400 together with the custom error message
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        String error;

        Object value = e.getValue();
        //If the input is empty, return a custom message
        if (value == "") {
            String variable = e.getName();
            error = "Variable \"" + variable + "\" cannot be empty.";

        //Only integers are allowed for height and
        } else {
            error = "Variable input \"" + value + "\" is invalid. The input must be an integer.";
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * This ExceptionController will handle all remaining exceptions
     * that have not been handled by the other ExceptionControllers.
     * The returned HTTP status code is 500 (Internal server error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleInternalServerErrorExceptions(Exception ex) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
