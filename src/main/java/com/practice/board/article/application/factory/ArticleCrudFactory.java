package com.practice.board.article.application.factory;

import com.practice.board.article.application.proxy.ArticleCrudProxy;
import com.practice.board.article.application.proxy.ArticleLongCrudProxy;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudFactory;
import com.practice.board.common.CrudProxy;
import org.springframework.stereotype.Component;

@Component
public class ArticleCrudFactory implements CrudFactory<ArticleDto> {
    private final CrudProxy<ArticleDto> crudProxy;
    
    public ArticleCrudFactory(final ArticleCrudProxy crudProxy, final ArticleLongCrudProxy longCrudProxy) {
        crudProxy.addProxy(longCrudProxy);
        this.crudProxy = crudProxy;
    }

    @Override
    public CrudProxy<ArticleDto> get() {
        return crudProxy;
    }
}
