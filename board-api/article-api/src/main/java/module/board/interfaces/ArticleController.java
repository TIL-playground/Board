package module.board.interfaces;

import lombok.RequiredArgsConstructor;
import module.board.application.ArticleApplicationProxyHandler;
import module.board.application.ArticleDto;
import module.board.common.HashUtil;
import module.board.common.request.PageRequest;
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
        final var dto = mapper.toDto(httpBody);
        handler.create(dto);
    }

    @GetMapping("/{id}")
    ArticleResponseDto getArticle(@PathVariable final String id) {
        final long decodedId = HashUtil.decode(id);
        final var result = (ArticleDto) handler.read(decodedId);

        return ArticleResponseDto.fromArticleDto(result);
    }

    @GetMapping
    List<ArticleResponseDto> getAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final var result = (List<ArticleDto>) handler.read(new PageRequest(page, size));

        if (result == null) {
            return Collections.emptyList();
        }

        return result.stream()
                .map(ArticleResponseDto::fromArticleDto)
                .toList();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateArticle(
            @PathVariable final String id,
            @RequestBody final ArticleRequestDto httpBody
    ) {
        final long decodedId = HashUtil.decode(id);
        final var dto = mapper.toDto(httpBody.addId(decodedId));

        handler.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteArticle(@PathVariable final String id) {
        final long decodedId = HashUtil.decode(id);
        handler.delete(decodedId);
    }
}
