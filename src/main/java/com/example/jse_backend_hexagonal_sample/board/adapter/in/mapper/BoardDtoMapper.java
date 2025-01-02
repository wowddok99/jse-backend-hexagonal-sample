package com.example.jse_backend_hexagonal_sample.board.adapter.in.mapper;

import com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto.BoardCreateCommand;
import com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import org.mapstruct.Mapper;

import java.time.Instant;

// DTO <-> Domain 매핑 클래스
@Mapper(componentModel = "spring")
public interface BoardDtoMapper {
    BoardDto toDto(Board board);

    Board toDomain(BoardCreateCommand command, Instant createdAt, Instant updatedAt);
}
