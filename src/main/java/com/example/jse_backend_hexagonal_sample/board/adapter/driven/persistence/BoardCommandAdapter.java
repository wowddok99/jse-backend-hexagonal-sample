package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper.BoardEntityMapper;
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

    @Override
    public Board updateBoard(Long id, Board board) {
        var existBoard = boardJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not Found"));

        var updateBoard = existBoard.toBuilder()
                .title(board.getTitle())
                .content(board.getContent())
                .updatedAt(Instant.now())
                .build();

        return boardEntityMapper.toDomain(boardJpaRepository.save(updateBoard));
    }

    @Override
    public void deleteBoard(Long id) {
        var existBoard = boardJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not Found"));

        // deletedAt 및 BoardStatus(REMOVED) 생성
        existBoard.softDelete();
    }
}
