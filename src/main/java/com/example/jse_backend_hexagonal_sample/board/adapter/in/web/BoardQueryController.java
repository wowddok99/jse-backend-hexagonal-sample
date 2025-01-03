package com.example.jse_backend_hexagonal_sample.board.adapter.in.web;

import com.example.jse_backend_hexagonal_sample.board.adapter.in.mapper.BoardDtoMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.in.web.dto.BoardDto;
import com.example.jse_backend_hexagonal_sample.board.application.usecase.BoardReadUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
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
}
