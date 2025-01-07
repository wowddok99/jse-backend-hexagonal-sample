package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Board> findBoardListByStatus(BoardStatus status, int pageNumber, int size) {
        // Sort 객체를 생성하여 정렬 기준을 설정합니다.
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

        // 페이지 번호와 페이지 크기를 사용하여 PageRequest 객체를 생성합니다.
        PageRequest pageRequest = PageRequest.of(pageNumber, size, sort);

        return boardJpaRepository.findBoardByStatus(status, pageRequest)
                .map(boardEntityMapper::toDomain);
    }
}
