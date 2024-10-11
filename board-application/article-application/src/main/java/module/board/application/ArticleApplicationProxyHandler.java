package module.board.application;

import module.board.common.proxy.CrudProxy;
import org.springframework.stereotype.Component;

@Component
public class ArticleApplicationProxyHandler {
    private final CrudProxy<ArticleDto> proxy;

    private ArticleApplicationProxyHandler(final ArticleCrudFactory factory) {
        proxy = factory.get();
    }

    public ArticleDto create(final Object... args) {
        return proxy.create(args);
    }

    public Object read(final Object... args) {
        return proxy.read(args);
    }

    public ArticleDto update(final Object... args) {
        return proxy.update(args);
    }

    public void delete(final Object... args) {
        proxy.delete(args);
    }
}
