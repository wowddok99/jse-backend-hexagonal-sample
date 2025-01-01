package com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, Long> {
}
