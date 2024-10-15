package module.board.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import module.board.application.ArticleApplicationProxyHandler;
import module.board.common.hash.HashUtil;
import module.board.common.http.HttpStatusUtil;
import module.board.common.request.PageRequest;
import module.board.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
class ArticleController {
    private final ArticleApplicationProxyHandler handler;
    private final ArticleHttpBodyMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<Void> createArticle(@RequestBody final ArticleRequestDto httpBody, HttpServletRequest request) {
        final var dto = mapper.toDto(httpBody);
        handler.create(dto);

        return ApiResponse.success(
                HttpStatusUtil.CREATED,
                request.getRequestURI()
        );
    }

    @GetMapping("/{id}")
    ApiResponse<ArticleResponseDto> getArticle(@PathVariable final String id, HttpServletRequest request) {
        final long decodedId = HashUtil.decode(id);
        final var result = handler.readOne(decodedId);

        return ApiResponse.success(
                HttpStatusUtil.OK,
                ArticleResponseDto.fromArticleDto(result),
                request.getRequestURI()
        );
    }

    @GetMapping
    ApiResponse<List<ArticleResponseDto>> getAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size,
            HttpServletRequest request
    ) {
        final var result = handler.readAll(new PageRequest(page, size));

        return ApiResponse.success(
                HttpStatusUtil.OK,
                result.stream()
                        .map(ArticleResponseDto::fromArticleDto)
                        .toList(),
                request.getRequestURI()
        );
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ApiResponse<Void> updateArticle(
            @PathVariable final String id,
            @RequestBody final ArticleRequestDto httpBody,
            HttpServletRequest request
    ) {
        final long decodedId = HashUtil.decode(id);
        final var dto = mapper.toDto(httpBody.addId(decodedId));

        handler.update(dto);

        return ApiResponse.success(
                HttpStatusUtil.NO_CONTENT,
                request.getRequestURI()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ApiResponse<Void> deleteArticle(@PathVariable final String id, HttpServletRequest request) {
        final long decodedId = HashUtil.decode(id);
        handler.delete(decodedId);

        return ApiResponse.success(
                HttpStatusUtil.NO_CONTENT,
                request.getRequestURI()
        );
    }
}
