package com.practice.board.article.application.service;

import com.practice.board.article.domain.ArticleDataFactory;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.DataProxy;
import org.springframework.stereotype.Service;

@Service
class ArticleServiceImpl implements ArticleService {
    private final DataProxy<ArticleDto> proxy;

    public ArticleServiceImpl(final ArticleDataFactory factory) {
        this.proxy = factory.get();
    }

    @Override
    public ArticleDto save(final ArticleDto dto) {
        return proxy.save(dto);
    }

    @Override
    public ArticleDto get(final Long id) {
        return proxy.get(id);
    }

    @Override
    public void delete(final Long id) {
        proxy.delete(id);
    }
}
