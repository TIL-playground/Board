package com.practice.board.article.interfaces;

import com.practice.board.article.application.ArticleCrudFactory;
import com.practice.board.article.domain.ArticleDto;
import com.practice.board.common.CrudProxy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
class ArticleController {
    private final CrudProxy<ArticleDto> crudProxy;
    private final ArticleHttpBodyMapper mapper;

    public ArticleController(final ArticleCrudFactory factory, final ArticleHttpBodyMapper mapper) {
        crudProxy = factory.get();
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createArticle(@RequestBody final ArticleRequestDto httpBody) {
        final var dto = mapper.toDto(httpBody);

        crudProxy.create(dto);
    }

    @GetMapping("/{id}")
    ArticleResponseDto getArticle(@PathVariable final Long id) {
        final var dto = crudProxy.read(id);

        return mapper.toResponse(dto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateArticle(
            @PathVariable final Long id,
            @RequestBody final ArticleRequestDto httpBody
    ) {
        final var dto = mapper.toDto(httpBody.addId(id));

        crudProxy.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteArticle(@PathVariable final Long id) {
        crudProxy.delete(id);
    }
}
