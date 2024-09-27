package com.practice.board.article.application;

import com.practice.board.article.domain.ArticleDto;

interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto get(Long id);
    void delete(Long id);
}