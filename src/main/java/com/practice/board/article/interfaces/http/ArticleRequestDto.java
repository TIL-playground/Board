package com.practice.board.article.interfaces.http;

import com.practice.board.article.domain.ArticleDto;
import jakarta.annotation.Nullable;

public record ArticleRequestDto(
        @Nullable Long id,
        String title,
        String content
) {
    public ArticleRequestDto addId(final Long id) {
        return new ArticleRequestDto(id, title, content);
    }
}
