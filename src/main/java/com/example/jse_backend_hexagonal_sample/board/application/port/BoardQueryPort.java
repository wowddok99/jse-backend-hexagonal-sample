package com.example.jse_backend_hexagonal_sample.board.application.port;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BoardQueryPort {
    Optional<Board> findById(Long id);
    Page<Board> findAll(Pageable pageable);
    Page<Board> findByStatusesList(Pageable pageable, List<BoardStatus> statuses);
    Page<Board> findActiveOrSuspendedBoards(Pageable pageable);

}
