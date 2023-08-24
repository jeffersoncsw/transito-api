package com.jwiltenburg.transito.api.exceptionhandler;

import com.jwiltenburg.transito.domain.exception.BusinessRuleException;
import com.jwiltenburg.transito.domain.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        var problemMessage = new ExceptionMessageResource();
        problemMessage.setStatus(status.value());
        problemMessage.setDataHora(OffsetDateTime.now());
        problemMessage.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problemMessage, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public final ResponseEntity<?> businessRuleException(BusinessRuleException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        var problemMessage = new ExceptionMessageResource();
        problemMessage.setStatus(status.value());
        problemMessage.setDataHora(OffsetDateTime.now());
        problemMessage.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problemMessage, new HttpHeaders(), status, request);
    }

}
