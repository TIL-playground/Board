package com.practice.board.article.interfaces.http;

public record ArticleResponseDto(
        String id,
        String title,
        String content
) {
}
