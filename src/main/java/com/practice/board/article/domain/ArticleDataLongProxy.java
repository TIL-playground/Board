package com.practice.board.article.domain;

import com.practice.board.common.DataProxy;
import com.practice.board.common.Proxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class ArticleDataLongProxy implements DataProxy<ArticleDto> {
    private final ArticleRepository repository;
    private DataProxy<ArticleDto> nextProxy;

    @Override
    @Transactional
    public ArticleDto save(final Object... args) {
        return nextProxy != null ? nextProxy.save(args) : null;
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleDto get(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            return repository.getById((Long) args[0]);
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            repository.deleteById((Long) args[0]);
        }
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
