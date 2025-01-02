package com.example.jse_backend_hexagonal_sample.board.adapter.in.web;

import com.example.jse_backend_hexagonal_sample.board.adapter.in.mapper.BoardDtoMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto.BoardCreateCommand;
import com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardCommandController {
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardDtoMapper boardDtoMapper;

    @PostMapping
    public ResponseEntity<BoardDto> create(@RequestBody @Valid BoardCreateCommand command) {

        var board = boardCreateUseCase.createBoard(boardDtoMapper.toDomain(command, Instant.now(), Instant.now()));

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }
}
