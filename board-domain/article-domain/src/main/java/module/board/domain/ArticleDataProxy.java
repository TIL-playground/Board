package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.DataProxy;
import module.board.common.request.PageRequest;
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
        if (args.length == 1 && args[0] instanceof final PageRequest pageRequest) {
            return repository.getAll(pageRequest.page(), pageRequest.size());
        }

        return proceedGet(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
