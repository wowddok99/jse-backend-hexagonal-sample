package com.example.jse_backend_hexagonal_sample.board.application.port;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;

import java.util.Optional;

public interface BoardQueryPort {
    Optional<Board> findBoardById(Long id);
}
