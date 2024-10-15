package module.board.application;

import module.board.common.proxy.CrudProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleApplicationProxyHandler {
    private final CrudProxy<ArticleDto> proxy;

    private ArticleApplicationProxyHandler(final ArticleCrudFactory factory) {
        proxy = factory.get();
    }

    public ArticleDto create(final Object... args) {
        return proxy.create(args);
    }

    public ArticleDto readOne(final Object... args) {
        return proxy.readOne(args);
    }

    public List<ArticleDto> readAll(final Object... args) {
        return proxy.readAll(args);
    }

    public ArticleDto update(final Object... args) {
        return proxy.update(args);
    }

    public void delete(final Object... args) {
        proxy.delete(args);
    }
}
