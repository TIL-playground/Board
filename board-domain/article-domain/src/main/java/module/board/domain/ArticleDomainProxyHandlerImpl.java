package module.board.domain;

import module.board.common.proxy.DataProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ArticleDomainProxyHandlerImpl implements ArticleDomainProxyHandler {
    private final DataProxy<ArticleDto> dataProxy;

    private ArticleDomainProxyHandlerImpl(final ArticleDataFactory factory) {
        dataProxy = factory.get();
    }

    @Override
    public ArticleDto save(final Object... args) {
        return dataProxy.save(args);
    }

    @Override
    public ArticleDto getOne(final Object... args) {
        return dataProxy.getOne(args);
    }

    @Override
    public List<ArticleDto> getAll(final Object... args) {
        return dataProxy.getAll(args);
    }

    @Override
    public void delete(final Object... args) {
        dataProxy.delete(args);
    }
}
