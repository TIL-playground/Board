package com.practice.board.article.domain;

import com.practice.board.common.DataProxy;
import org.springframework.stereotype.Component;

@Component
public class ArticleDomainProxyHandler {
    private final DataProxy<ArticleDto> dataProxy;

    private ArticleDomainProxyHandler(final ArticleDataFactory factory) {
        dataProxy = factory.get();
    }

    public ArticleDto save(final Object... args) {
        return dataProxy.save(args);
    }

    public ArticleDto get(final Object... args) {
        return dataProxy.get(args);
    }

    public void delete(final Object... args) {
        dataProxy.delete(args);
    }
}
