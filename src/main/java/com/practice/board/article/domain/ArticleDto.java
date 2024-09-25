package com.practice.board.article.domain;

import lombok.Builder;

@Builder
public record ArticleDto(
        Long id,
        String title,
        String content
) {
}
