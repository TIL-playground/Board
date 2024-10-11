package module.board.application;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.CrudProxy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ArticleLongCrudProxy extends CrudProxy<ArticleDto> {
    private final ArticleService service;

    @Override
    public ArticleDto create(final Object... args) {
        return proceedCreate(args);
    }

    @Override
    public Object read(final Object... args) {
        return service.get(args[0]);
    }

    @Override
    public ArticleDto update(final Object... args) {
        return proceedUpdate(args);
    }

    @Override
    public void delete(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            service.delete((Long) args[0]);
        } else {
            proceedDelete(args);
        }
    }
}
