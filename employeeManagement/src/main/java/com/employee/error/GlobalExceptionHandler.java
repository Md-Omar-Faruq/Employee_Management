package com.employee.error;

import com.employee.controller.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                        WebRequest request){

        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                ex.getMessage()
        );

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        //return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }

}
