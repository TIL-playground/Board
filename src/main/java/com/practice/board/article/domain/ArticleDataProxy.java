package com.practice.board.article.domain;

import com.practice.board.common.DataProxy;
import com.practice.board.common.Proxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class ArticleDataProxy implements DataProxy<ArticleDto> {
    private final ArticleRepository repository;
    private DataProxy<ArticleDto> nextProxy;

    @Override
    @Transactional
    public ArticleDto save(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            return repository.save((ArticleDto) args[0]);
        }

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleDto get(final Object... args) {
        return nextProxy != null ? nextProxy.get(args) : null;
    }

    @Override
    @Transactional
    public void delete(final Object... args) {
        if (nextProxy != null) nextProxy.delete(args);
    }

    @Override
    public void addProxy(final Proxy<ArticleDto> proxy) {
        assert proxy != null;

        if (nextProxy == null) {
            if (proxy instanceof DataProxy) {
                nextProxy = (DataProxy<ArticleDto>) proxy;
            }
        }
        else nextProxy.addProxy(proxy);
    }
}
