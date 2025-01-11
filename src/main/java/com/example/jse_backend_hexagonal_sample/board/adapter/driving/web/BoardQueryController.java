package com.example.jse_backend_hexagonal_sample.board.adapter.driving.web;

import com.example.jse_backend_hexagonal_sample.board.adapter.driving.mapper.BoardDtoMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.driving.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardReadUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Validated
public class BoardQueryController {

    private final BoardReadUseCase boardReadUseCase;
    private final BoardDtoMapper boardDtoMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BoardDto> getBoard(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id
    ) {
        var board = boardReadUseCase.getBoard(id);

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<BoardDto>> getBoards(Pageable pageable) {
        var boards = boardReadUseCase.getBoards(pageable).stream()
                .map(boardDtoMapper::toDto).toList();

        return ResponseEntity.ok(new PageImpl<>(boards));
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<BoardDto>> getBoardsByStatus(
            @PathVariable("status")
            BoardStatus status,
            Pageable pageable
    ) {
        var boards = boardReadUseCase.getBoardsByStatus(status, pageable).stream()
                .map(boardDtoMapper::toDto).toList();

        return ResponseEntity.ok(new PageImpl<>(boards));
    }

    @GetMapping("/status/active-suspended")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<BoardDto>> getActiveAndSuspendedBoards(Pageable pageable) {
        var boards = boardReadUseCase.getActiveAndSuspendedBoards(pageable).stream()
                .map(boardDtoMapper::toDto).toList();

        return ResponseEntity.ok(new PageImpl<>(boards));
    }
}
