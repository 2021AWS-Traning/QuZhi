package com.graphql.java.persondetails.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static java.util.Collections.singletonMap;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<Map> handleGeneralException(Throwable ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(singletonMap("error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

