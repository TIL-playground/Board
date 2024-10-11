package module.board.domain;

import module.board.common.DataProxy;
import org.springframework.stereotype.Component;

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
    public Object get(final Object... args) {
        return dataProxy.get(args);
    }

    @Override
    public void delete(final Object... args) {
        dataProxy.delete(args);
    }
}
