package com.example.jse_backend_hexagonal_sample.board.application.service;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardCommandPort;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardCreateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 비즈니스 로직을 처리하는 서비스 클래스
@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase {

    private final BoardCommandPort boardCommandPort;

    @Override
    @Transactional
    public Board createBoard(Board board) {
        return boardCommandPort.createBoard(board);
    }
}
