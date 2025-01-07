package com.example.jse_backend_hexagonal_sample.board.adapter.driving.mapper;

import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardCreateCommand;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardUpdateCommand;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

// DTO <-> Domain 매핑 클래스
@Mapper(componentModel = "spring")
public interface BoardDtoMapper {
    BoardDto toDto(Board board);

    Board toDomain(BoardCreateCommand command, BoardStatus status, Instant createdAt, Instant updatedAt);

    Board toDomain(BoardUpdateCommand command);

}
