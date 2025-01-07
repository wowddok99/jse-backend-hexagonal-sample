package com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto;

import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;

import java.time.Instant;

public record BoardDto(
        Long id,
        String title,
        String content,
        BoardStatus status,
        Instant createdAt,
        Instant updatedAt
) {}
