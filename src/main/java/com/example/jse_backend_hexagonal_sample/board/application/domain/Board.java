package com.example.jse_backend_hexagonal_sample.board.application.domain;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;


// 애플리케이션이 라이브러리를 의존하지 않기 위해 도메인과 도메인 엔터티로 나눕니다.
// 비즈니스 도메인 정의
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long id;

    private String title;

    private String content;

    private Instant createdAt;

    private Instant updatedAt;
}
