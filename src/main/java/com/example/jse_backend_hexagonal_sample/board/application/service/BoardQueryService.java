package com.example.jse_backend_hexagonal_sample.board.application.service;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.exception.BoardQueryErrorCode;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardReadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
                .orElseThrow(BoardQueryErrorCode.BOARD_NOT_FOUND::defaultException);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoardList(int pageNumber, int size) {
        return boardQueryPort.findBoarList(pageNumber, size);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoardListByStatus(BoardStatus status, int pageNumber, int size) {
        return boardQueryPort.findBoardListByStatus(status, pageNumber, size);
    }
}
