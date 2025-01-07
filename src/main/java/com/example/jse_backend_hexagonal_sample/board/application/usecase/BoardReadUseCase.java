package com.example.jse_backend_hexagonal_sample.board.application.usecase;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;

public interface BoardReadUseCase {
    Board getBoard (Long id);
    Page<Board> getBoards(int pageNumber, int size);
    Page<Board> getBoardsByStatus(BoardStatus status, int pageNumber, int size);
    Page<Board> getActiveAndSuspendedBoards(int pageNumber, int size);
}
