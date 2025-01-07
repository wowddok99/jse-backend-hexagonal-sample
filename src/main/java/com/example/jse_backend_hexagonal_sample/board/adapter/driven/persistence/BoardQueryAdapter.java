package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
}
