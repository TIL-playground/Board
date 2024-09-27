package com.practice.board.article.application;

import com.practice.board.article.domain.ArticleDomainProxyHandler;
import com.practice.board.article.domain.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ArticleServiceImpl implements ArticleService {
    private final ArticleDomainProxyHandler handler;

    @Override
    public ArticleDto save(final ArticleDto dto) {
        return handler.save(dto);
    }

    @Override
    public ArticleDto get(final Long id) {
        return handler.get(id);
    }

    @Override
    public void delete(final Long id) {
        handler.delete(id);
    }
}
