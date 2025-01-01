package com.example.jse_backend_hexagonal_sample.board.application.usecase;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;

// 특정 유스케이스(기능) 인터페이스
public interface BoardCreateUseCase {
    Board createBoard (Board board);
}
