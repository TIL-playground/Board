package com.practice.board.article.domain;

public interface ArticleRepository {
    ArticleDto getById(Long id);
    ArticleDto save(ArticleDto article);
    void deleteById(Long id);
}
