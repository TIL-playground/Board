package com.practice.board.article.interfaces;

import jakarta.annotation.Nullable;

record ArticleRequestDto(
        @Nullable Long id,
        String title,
        String content
) {
    public ArticleRequestDto addId(final Long id) {
        return new ArticleRequestDto(id, title, content);
    }
}
