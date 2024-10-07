package module.board.interfaces;

import lombok.RequiredArgsConstructor;
import module.board.application.ArticleApplicationProxyHandler;
import module.board.application.ArticleDto;
import module.board.common.HashUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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
    ArticleResponseDto getArticle(@PathVariable final String id) {
        return ArticleResponseDto.fromArticleDto((ArticleDto) handler.read(HashUtil.decode(id)));
    }

    @GetMapping
    List<ArticleResponseDto> getAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final var result = handler.read(page, size);

        if (result == null) {
            return Collections.emptyList();
        }

        return ((List<ArticleDto>) result).stream()
                .map(ArticleResponseDto::fromArticleDto)
                .toList();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateArticle(
            @PathVariable final String id,
            @RequestBody final ArticleRequestDto httpBody
    ) {
        handler.update(mapper.toDto(httpBody.addId(HashUtil.decode(id))));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteArticle(@PathVariable final String id) {
        handler.delete(HashUtil.decode(id));
    }
}
