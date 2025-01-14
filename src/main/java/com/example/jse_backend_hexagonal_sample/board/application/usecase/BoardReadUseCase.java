package com.example.jse_backend_hexagonal_sample.board.application.usecase;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardReadUseCase {
    Board getBoard (Long id);
    Page<Board> getBoards(Pageable pageable);
    Page<Board> getBoardsByStatus(Pageable pageable, List<BoardStatus> statuses);
    Page<Board> getActiveOrSuspendedBoards(Pageable pageable);
}
