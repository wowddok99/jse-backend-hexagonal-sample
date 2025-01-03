package com.example.jse_backend_hexagonal_sample.board.application.usecase;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;

public interface BoardReadUseCase {
    Board getBoard (Long id);
}
