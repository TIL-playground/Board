package module.board.domain;

import lombok.Builder;

@Builder
public record ArticleDto(
        Long id,
        String title,
        String content
) {
}
