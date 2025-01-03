package com.example.jse_backend_hexagonal_sample.board.application.service;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardCommandPort;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardCreateUseCase;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardDeleteUseCase;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardUpdateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 비즈니스 로직을 처리하는 서비스 클래스
@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase, BoardUpdateUseCase, BoardDeleteUseCase {

    private final BoardCommandPort boardCommandPort;

    @Override
    @Transactional
    public Board createBoard(Board board) {
        return boardCommandPort.createBoard(board);
    }

    @Override
    @Transactional
    public Board updateBoard(Long id, Board board) {
        return boardCommandPort.updateBoard(id, board);
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) { boardCommandPort.deleteBoard(id); }
}
