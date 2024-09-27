package com.practice.board.article.application;

import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import org.springframework.stereotype.Component;

@Component
public class ArticleApplicationProxyHandler {
    private final CrudProxy<ArticleDto> proxy;

    private ArticleApplicationProxyHandler(final ArticleCrudFactory factory) {
        proxy = factory.get();
    }

    public ArticleDto create(final Object... args) {
        return proxy.create(args);
    }

    public ArticleDto read(final Object... args) {
        return proxy.read(args);
    }

    public ArticleDto update(final Object... args) {
        return proxy.update(args);
    }

    public void delete(final Object... args) {
        proxy.delete(args);
    }
}
