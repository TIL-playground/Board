package com.practice.board.article.domain;

import com.practice.board.common.DataProxy;
import com.practice.board.common.Factory;
import org.springframework.stereotype.Component;

@Component
public class ArticleDataFactory implements Factory<ArticleDto> {
    private final DataProxy<ArticleDto> dataProxy;

    private ArticleDataFactory(final ArticleDataProxy dataProxy, final ArticleDataLongProxy dataLongProxy) {
        dataProxy.addProxy(dataLongProxy);
        this.dataProxy = dataProxy;
    }

    @Override
    public DataProxy<ArticleDto> get() {
        return dataProxy;
    }
}
