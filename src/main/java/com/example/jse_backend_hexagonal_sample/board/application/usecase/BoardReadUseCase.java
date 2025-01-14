package com.example.jse_backend_hexagonal_sample.board.application.usecase;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReadUseCase {
    Board getBoard (Long id);
    Page<Board> getBoards(Pageable pageable);
    Page<Board> getBoardsByStatus(BoardStatus status, Pageable pageable);
    Page<Board> getActiveAndSuspendedBoards(int pageNumber, int size);
}
