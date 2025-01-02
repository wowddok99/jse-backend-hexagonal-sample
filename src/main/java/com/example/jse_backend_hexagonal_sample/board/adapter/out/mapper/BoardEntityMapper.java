package com.example.jse_backend_hexagonal_sample.board.adapter.out.mapper;

import com.example.jse_backend_hexagonal_sample.board.adapter.out.persistence.entity.BoardEntity;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.util.Optional;

// Entity <-> Domain 매핑 클래스
@Mapper(componentModel = "spring")
public interface BoardEntityMapper {
    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);
}
