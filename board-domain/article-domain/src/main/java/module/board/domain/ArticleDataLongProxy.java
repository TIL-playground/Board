package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.DataProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class ArticleDataLongProxy extends DataProxy<ArticleDto> {
    private final ArticleRepository repository;

    @Override
    @Transactional
    public ArticleDto save(final Object... args) {
        return proceedSave(args);
    }

    @Override
    @Transactional(readOnly = true)
    public Object get(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            return repository.getById((Long) args[0]);
        }

        return proceedGet(args);
    }

    @Override
    @Transactional
    public void delete(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            repository.deleteById((Long) args[0]);
        }
    }
}
