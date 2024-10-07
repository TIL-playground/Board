package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.DataProxy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ArticleDataProxy extends DataProxy<ArticleDto> {
    private final ArticleRepository repository;

    @Override
    public ArticleDto save(final Object... args) {
        return proceedSave(args);
    }

    @Override
    public Object get(final Object... args) {
        if (args.length == 2 && args[0] instanceof Integer && args[1] instanceof Integer) {
            return repository.getAll(
                    (int) args[0],
                    (int) args[1]
            );
        }

        return proceedGet(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
