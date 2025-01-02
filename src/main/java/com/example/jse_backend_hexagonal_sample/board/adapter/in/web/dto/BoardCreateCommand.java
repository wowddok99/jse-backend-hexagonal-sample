package com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record BoardCreateCommand(
        @NotNull String title,
        @NotNull String content
) {
}
