package com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto;

import jakarta.validation.constraints.NotNull;

public record BoardCreateCommand(
        @NotNull String title,
        @NotNull String content
) {
}
