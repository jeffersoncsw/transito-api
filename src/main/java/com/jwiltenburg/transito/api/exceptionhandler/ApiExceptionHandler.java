package com.jwiltenburg.transito.api.exceptionhandler;

import com.jwiltenburg.transito.domain.exception.BusinessRuleException;
import com.jwiltenburg.transito.domain.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ExceptionMessageResource.Campo> campos = new ArrayList<>();
        for (ObjectError error: ex.getBindingResult().getAllErrors()){
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new ExceptionMessageResource.Campo(name, message));
        }

        var problemDetail = new ExceptionMessageResource();
        problemDetail.setStatus(status.value());
        problemDetail.setDataHora(OffsetDateTime.now());
        problemDetail.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        problemDetail.setCampo(campos);

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        var problemDetail = new ExceptionMessageResource();
        problemDetail.setStatus(status.value());
        problemDetail.setDataHora(OffsetDateTime.now());
        problemDetail.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public final ResponseEntity<?> businessRuleException(BusinessRuleException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        var problemDetail = new ExceptionMessageResource();
        problemDetail.setStatus(status.value());
        problemDetail.setDataHora(OffsetDateTime.now());
        problemDetail.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status, request);
    }

}
