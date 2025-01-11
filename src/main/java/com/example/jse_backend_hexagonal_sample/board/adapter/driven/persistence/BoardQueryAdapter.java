package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class BoardQueryAdapter implements BoardQueryPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    @Override
    public Optional<Board> findBoardById(Long id) {
        return boardJpaRepository.findById(id)
                .map(boardEntityMapper::toDomain);
    }

    @Override
    public Page<Board> findBoards(Pageable pageable) {
        return boardJpaRepository.findAll(pageable)
                .map(boardEntityMapper::toDomain);
    }

    @Override
    public Page<Board> findBoardsByStatus(BoardStatus status, Pageable pageable) {
        return boardJpaRepository.findByStatus(status, pageable)
                .map(boardEntityMapper::toDomain);
    }

    @Override
    public Page<Board> findActiveAndSuspendedBoards(Pageable pageable) {
        // ACTIVE, SUSPENDED
        Set<BoardStatus> statuses = BoardStatus.getGeneralQueryStatus();

        return boardJpaRepository.findByStatusIn(statuses, pageable)
                .map(boardEntityMapper::toDomain);
    }
}
