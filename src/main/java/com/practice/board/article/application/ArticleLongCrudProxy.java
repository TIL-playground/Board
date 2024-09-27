package com.practice.board.article.application;

import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import lombok.RequiredArgsConstructor;
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
    public ArticleDto read(final Object... args) {
        if (args.length == 1 && args[0] instanceof Long) {
            return service.get((Long) args[0]);
        }

        return proceedRead(args);
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
