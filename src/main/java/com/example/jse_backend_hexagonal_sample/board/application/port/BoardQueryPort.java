package com.example.jse_backend_hexagonal_sample.board.application.port;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BoardQueryPort {
    Optional<Board> findBoardById(Long id);
    Page<Board> findBoards(int pageNumber, int size);
    Page<Board> findBoardsByStatus(BoardStatus status, int pageNumber, int size);
    Page<Board> findActiveAndSuspendedBoards(int pageNumber, int size);

}
