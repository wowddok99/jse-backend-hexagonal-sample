package com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence;

import com.example.jse_backend_hexagonal_sample.board.adapter.driven.mapper.BoardEntityMapper;
import com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence.entity.BoardEntity;
import com.example.jse_backend_hexagonal_sample.board.adapter.driven.persistence.entity.QBoardEntity;
import com.example.jse_backend_hexagonal_sample.board.application.domain.Board;
import com.example.jse_backend_hexagonal_sample.board.application.domain.type.BoardStatus;
import com.example.jse_backend_hexagonal_sample.board.application.port.BoardQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class BoardQueryAdapter extends QuerydslRepositorySupport implements BoardQueryPort {
    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    public BoardQueryAdapter(BoardJpaRepository boardJpaRepository, BoardEntityMapper boardEntityMapper) {
        super(BoardEntity.class);
        this.boardJpaRepository = boardJpaRepository;
        this.boardEntityMapper = boardEntityMapper;
    }

    @Override
    public Optional<Board> findBoardById(Long id) {
        return boardJpaRepository.findById(id)
                .map(boardEntityMapper::toDomain);
    }

    @Override
    public Page<Board> findBoards(Pageable pageable) {
        QBoardEntity boardEntity = QBoardEntity.boardEntity;

        // 기본 쿼리 생성
        var query = getQuerydsl().createQuery()
                .select(boardEntity)
                .from(boardEntity)
                .where(boardEntity.status.ne(BoardStatus.REMOVED));

        // pageable에서 정렬 조건 적용
        pageable.getSort().forEach(order -> {
            if (order.isAscending()) {
                query.orderBy(boardEntity.createdAt.asc()); // createdAt 필드를 기준으로 오름차순 정렬
            } else {
                query.orderBy(boardEntity.createdAt.desc()); // createdAt 필드를 기준으로 내림차순 정렬
            }
        });

        var result = query
                .offset(pageable.getOffset()) // 현재 페이지의 오프셋 설정
                .limit(pageable.getPageSize()) // 페이지 크기 설정
                .fetch(); // 쿼리 실행

        var totalCount  = getQuerydsl().createQuery()
                .select(boardEntity.count())
                .from(boardEntity)
                .where(boardEntity.status.ne(BoardStatus.REMOVED));

        return PageableExecutionUtils.getPage(
                result.stream().map(boardEntityMapper::toDomain).toList(),
                pageable,
                totalCount::fetchOne
        );
    }

    @Override
    public Page<Board> findBoardsByStatus(BoardStatus status, Pageable pageable) {
        return boardJpaRepository.findByStatus(status, pageable)
                .map(boardEntityMapper::toDomain);
    }

    @Override
    public Page<Board> findActiveAndSuspendedBoards(int pageNumber, int size) {
        // ACTIVE, SUSPENDED
        Set<BoardStatus> statuses = BoardStatus.getGeneralQueryStatus();

        // Sort 객체를 생성하여 정렬 기준을 설정합니다.
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

        // 페이지 번호와 페이지 크기를 사용하여 PageRequest 객체를 생성합니다.
        PageRequest pageRequest = PageRequest.of(pageNumber, size, sort);

        return boardJpaRepository.findByStatusIn(statuses, pageRequest)
                .map(boardEntityMapper::toDomain);
    }
}
