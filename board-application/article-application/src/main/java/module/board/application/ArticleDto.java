package module.board.application;

import lombok.Builder;

@Builder
public record ArticleDto(
        Long id,
        String title,
        String content
) {
}
