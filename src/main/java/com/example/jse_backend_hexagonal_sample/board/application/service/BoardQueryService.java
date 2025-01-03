package com.example.jse_backend_hexagonal_sample.board.application.service;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardReadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase {

    private final BoardQueryPort boardQueryPort;
    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        return boardQueryPort.findBoardById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not Fount"));
    }
}
