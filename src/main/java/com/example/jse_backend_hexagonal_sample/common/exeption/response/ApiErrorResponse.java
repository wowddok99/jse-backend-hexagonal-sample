package com.example.jse_backend_hexagonal_sample.common.exeption.response;

import lombok.Builder;

@Builder
public record ApiErrorResponse(
        int status,
        String code,
        String message
) {}
