package com.practice.board.article.application.proxy;

import com.practice.board.article.application.service.ArticleService;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleLongCrudProxy implements CrudProxy<ArticleDto> {
    private CrudProxy<ArticleDto> nextProxy;
    private final ArticleService service;

    @Override
    public ArticleDto create(final Object... args) {
        return nextProxy != null ? nextProxy.create(args) : null;
    }

    @Override
    public ArticleDto read(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            return service.get((Long) args[0]);
        }

        return null;
    }

    @Override
    public ArticleDto update(final Object... args) {
        return nextProxy != null ? nextProxy.update(args) : null;
    }

    @Override
    public void delete(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            service.delete((Long) args[0]);
        }
    }

    @Override
    public void addProxy(final CrudProxy<ArticleDto> crudProxy) {
        if (nextProxy != null) nextProxy = crudProxy;
        else nextProxy.addProxy(crudProxy);
    }
}
