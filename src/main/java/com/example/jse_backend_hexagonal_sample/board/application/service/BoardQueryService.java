package com.example.jse_backend_hexagonal_sample.board.application.service;

import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.exception.BoardQueryErrorCode;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardReadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase {

    private final BoardQueryPort boardQueryPort;
    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        return boardQueryPort.findById(id)
                .orElseThrow(BoardQueryErrorCode.BOARD_NOT_FOUND::defaultException);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoards(Pageable pageable) {
        return boardQueryPort.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoardsByStatus(Pageable pageable, List<BoardStatus> statuses) {
        return boardQueryPort.findByStatusesList(pageable, statuses);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getActiveOrSuspendedBoards(Pageable pageable) {
        return boardQueryPort.findActiveOrSuspendedBoards(pageable);
    }
}
