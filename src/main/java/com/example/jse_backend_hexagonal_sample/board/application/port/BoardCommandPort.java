package com.example.jse_backend_hexagonal_sample.board.application.port;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;

// 어댑터와 상호작용을 위한 인터페이스 정의
public interface BoardCommandPort {
    Board createBoard(Board board);
    Board updateBoard(Long id, Board board);
}
