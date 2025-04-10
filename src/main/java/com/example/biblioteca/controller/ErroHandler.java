package com.example.biblioteca.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ErroHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult()
                               .getFieldErrors()
                               .stream()
                               .map(e -> e.getDefaultMessage())
                               .toList();

        return ResponseEntity.badRequest().body(Map.of("erros", erros));
    }
}
