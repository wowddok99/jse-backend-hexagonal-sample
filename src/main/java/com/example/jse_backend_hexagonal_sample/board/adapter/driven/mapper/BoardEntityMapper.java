package com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence.entity.BoardEntity;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import org.mapstruct.Mapper;

import java.util.Optional;

// Entity <-> Domain 매핑 클래스
@Mapper(componentModel = "spring")
public interface BoardEntityMapper {
    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);

    default Optional<Board> toOptionalDomain(BoardEntity boardEntity) {
        return Optional.ofNullable(toDomain(boardEntity));
    }
}
