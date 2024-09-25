package com.practice.board.article.application.service;

import com.practice.board.article.domain.ArticleDto;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto get(Long id);
    void delete(Long id);
}