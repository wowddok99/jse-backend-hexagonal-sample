package com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.out.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardCommandPort;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardQueryAdapter implements BoardQueryPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    @Override
    public Optional<Board> findBoardById(Long id) {
        return boardEntityMapper.toOptionalDomain(
                boardJpaRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Board not Found"))
        );
    }
}
