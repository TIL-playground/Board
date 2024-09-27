package com.practice.board.article.interfaces;

import com.practice.board.article.application.ArticleApplicationProxyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
class ArticleController {
    private final ArticleApplicationProxyHandler handler;
    private final ArticleHttpBodyMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createArticle(@RequestBody final ArticleRequestDto httpBody) {
        handler.create(mapper.toDto(httpBody));
    }

    @GetMapping("/{id}")
    ArticleResponseDto getArticle(@PathVariable final Long id) {
        return mapper.toResponse(handler.read(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateArticle(
            @PathVariable final Long id,
            @RequestBody final ArticleRequestDto httpBody
    ) {
        handler.update(mapper.toDto(httpBody.addId(id)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteArticle(@PathVariable final Long id) {
        handler.delete(id);
    }
}
