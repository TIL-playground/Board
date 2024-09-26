package com.practice.board.article.domain;

import com.practice.board.common.DataProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class ArticleDataProxy extends DataProxy<ArticleDto> {
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
    public ArticleDto get(final Object... args) {
        return proceedGet(args);
    }

    @Override
    @Transactional
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
