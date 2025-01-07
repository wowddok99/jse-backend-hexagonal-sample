package com.example.jse_backend_hexagonal_sample.board.adapter.driving.web;

import com.example.jse_backend_hexagonal_sample.board.adapter.driving.mapper.BoardDtoMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardCreateCommand;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardUpdateCommand;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardCreateUseCase;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardDeleteUseCase;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardUpdateUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Validated
public class BoardCommandController {
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardUpdateUseCase boardUpdateUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;
    private final BoardDtoMapper boardDtoMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BoardDto> create(@RequestBody @Valid BoardCreateCommand command) {

        var board = boardCreateUseCase.createBoard(boardDtoMapper.toDomain(command, Instant.now(), Instant.now()));

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BoardDto> update(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id,
            @RequestBody @Valid BoardUpdateCommand command
    ) {
        var board = boardUpdateUseCase.updateBoard(id, boardDtoMapper.toDomain(command));

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id
    ) {
        boardDeleteUseCase.deleteBoard(id);
    }
}
