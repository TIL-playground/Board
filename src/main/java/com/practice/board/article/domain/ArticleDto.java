package com.practice.board.article.domain;

import lombok.Builder;

@Builder
public record ArticleDto(
        Long id,
        String title,
        String content
) {
    public ArticleDto addId(final Long id) {
        return new ArticleDto(id, title, content);
    }
}
