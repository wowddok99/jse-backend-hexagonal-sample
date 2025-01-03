package com.example.jse_backend_hexagonal_sample.common.exeption;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name(); // enum default method
    String defaultMessage();
    HttpStatus defaultHttpStatus();
    RuntimeException defaultException();
    RuntimeException defaultException(Throwable cause);
}
