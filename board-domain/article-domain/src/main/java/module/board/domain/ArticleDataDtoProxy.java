package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.DataProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
class ArticleDataDtoProxy extends DataProxy<ArticleDto> {
    private final ArticleRepository repository;

    @Override
    @Transactional
    public ArticleDto save(final Object... args) {
        if (args.length == 1 && args[0] instanceof ArticleDto) {
            return repository.save((ArticleDto) args[0]);
        }

        return proceedSave(args);
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleDto getOne(final Object... args) {
        return proceedGetOne(args);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleDto> getAll(final Object... args) {
        return proceedGetAll(args);
    }

    @Override
    @Transactional
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
