package com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto;

import java.time.Instant;

public record BoardDto(
        Long id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
