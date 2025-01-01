package com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.out.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence.entity.BoardEntity;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
@RequiredArgsConstructor
public class BoardCommandAdapter implements BoardCommandPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    @Override
    public Board createBoard(Board board) {
        var boardEntity = boardEntityMapper.toEntity(board);

        return boardEntityMapper.toDomain(boardJpaRepository.save(boardEntity));
    }
}
