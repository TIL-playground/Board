package module.board.application;

import lombok.RequiredArgsConstructor;
import module.board.common.CrudProxy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ArticleDtoCrudProxy extends CrudProxy<ArticleDto> {
    private final ArticleService service;

    @Override
    public ArticleDto create(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            return service.save((ArticleDto) args[0]);
        }

        return proceedCreate(args);
    }

    @Override
    public Object read(final Object... args) {
        return service.get(args);
    }

    @Override
    public ArticleDto update(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            final var dto = service.get(((ArticleDto) args[0]).id());
            final var writeTimestamp = ((ArticleDto) dto).writeTimestamp();
            final var updatedDto = ((ArticleDto) args[0]).addWriteTimestamp(writeTimestamp);

            return service.save(updatedDto);
        }
        
        return proceedUpdate(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
