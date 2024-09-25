package com.practice.board.article.interfaces;

import com.practice.board.article.application.factory.ArticleCrudFactory;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
class ArticleController {
    private final CrudProxy<ArticleDto> crudProxy;

    public ArticleController(final ArticleCrudFactory factory) {
        crudProxy = factory.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createArticle(@RequestBody final ArticleDto dto) {
        crudProxy.create(dto);
    }

    @GetMapping("/{id}")
    ArticleDto getArticle(@PathVariable final Long id) {
        return crudProxy.read(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateArticle(
            @PathVariable final Long id,
            @RequestBody final ArticleDto dto
    ) {
        crudProxy.update(dto.addId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteArticle(@PathVariable final Long id) {
        crudProxy.delete(id);
    }

}
