package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence.entity.BoardEntity;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, Long> {
    Page<BoardEntity> findByStatusIn(Set<BoardStatus> statuses, Pageable pageable);
    Page<BoardEntity> findByStatus(BoardStatus status, Pageable pageable);
}
