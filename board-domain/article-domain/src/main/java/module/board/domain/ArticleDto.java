package module.board.domain;

import java.time.Instant;

public record ArticleDto(
        Long id,
        String title,
        String content,
        Instant writeTimestamp,
        Boolean isPublic
) {
}
