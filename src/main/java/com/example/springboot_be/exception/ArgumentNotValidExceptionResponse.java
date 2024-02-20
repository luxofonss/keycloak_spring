package com.example.springboot_be.exception;

import java.util.Map;

public record ArgumentNotValidExceptionResponse (
        String message,
        Map<String, String> errors
) {
}
