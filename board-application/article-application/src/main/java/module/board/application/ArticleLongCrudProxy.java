package module.board.application;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.CrudProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ArticleLongCrudProxy extends CrudProxy<ArticleDto> {
    private final ArticleService service;

    @Override
    public ArticleDto create(final Object... args) {
        return proceedCreate(args);
    }

    @Override
    public ArticleDto readOne(final Object... args) {
        return service.getOne(args);
    }

    @Override
    public List<ArticleDto> readAll(final Object... args) {
        return service.getAll(args);
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
