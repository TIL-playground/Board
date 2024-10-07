package module.board.interfaces;

import lombok.RequiredArgsConstructor;
import module.board.application.ArticleApplicationProxyHandler;
import module.board.application.ArticleDto;
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
    ArticleResponseDto getArticle(@PathVariable final Long id) {
        return mapper.toResponse((ArticleDto) handler.read(id));
    }

    @GetMapping
    List<ArticleResponseDto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        final var result = handler.read(page, size);

        if (result != null) {
            return ((List<ArticleDto>) result).stream()
                    .map(mapper::toResponse)
                    .toList();
        }

        return Collections.emptyList();
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
