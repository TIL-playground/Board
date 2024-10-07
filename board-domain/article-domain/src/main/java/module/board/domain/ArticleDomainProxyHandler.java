package module.board.domain;

import module.board.common.DataProxy;
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

    public Object get(final Object... args) {
        return dataProxy.get(args);
    }

    public void delete(final Object... args) {
        dataProxy.delete(args);
    }
}
