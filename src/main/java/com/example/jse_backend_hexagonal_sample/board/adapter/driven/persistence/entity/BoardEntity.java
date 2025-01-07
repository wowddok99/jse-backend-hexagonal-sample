package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence.entity;

import com.example.jse_backend_hexagonal_sample.common.support.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Entity(name = "board")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Column(name = "content", length = 300, nullable = false)
    private String content;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    // 삭제
    public void softDelete() {
        this.deletedAt = Instant.now();
    }
}
