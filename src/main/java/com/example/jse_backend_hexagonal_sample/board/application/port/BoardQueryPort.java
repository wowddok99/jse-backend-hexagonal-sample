package com.example.jse_backend_hexagonal_sample.board.application.port;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardQueryPort {
    Optional<Board> findBoardById(Long id);
    Page<Board> findBoards(Pageable pageable);
    Page<Board> findBoardsByStatus(BoardStatus status, Pageable pageable);
    Page<Board> findActiveOrSuspendedBoards(Pageable pageable);

}
