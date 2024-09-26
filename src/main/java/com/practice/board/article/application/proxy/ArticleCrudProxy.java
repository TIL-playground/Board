package com.practice.board.article.application.proxy;

import com.practice.board.article.application.service.ArticleService;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import com.practice.board.common.Proxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ArticleCrudProxy implements CrudProxy<ArticleDto> {
    private CrudProxy<ArticleDto> nextProxy;
    private final ArticleService service;

    @Override
    public ArticleDto create(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            return service.save((ArticleDto) args[0]);
        }

        return null;
    }

    @Override
    public ArticleDto read(final Object... args) {
        return nextProxy != null ? nextProxy.read(args) : null;
    }

    @Override
    public ArticleDto update(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            return service.save((ArticleDto) args[0]);
        }
        
        return null;
    }

    @Override
    public void delete(final Object... args) {
        if (nextProxy != null) nextProxy.delete(args);
    }

    @Override
    public void addProxy(final Proxy<ArticleDto> proxy) {
        assert proxy != null;

        if (nextProxy == null) {
            if (proxy instanceof CrudProxy) {
                nextProxy = (CrudProxy<ArticleDto>) proxy;
            }
        }
        else nextProxy.addProxy(proxy);
    }
}
