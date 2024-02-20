package com.example.springboot_be.shared;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ApiResponse(Object data, HttpStatus status, String message) {
}
