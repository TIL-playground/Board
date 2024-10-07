package module.board.application;

import java.time.Instant;

public record ArticleDto(
        Long id,
        String title,
        String content,
        Instant writeTimestamp,
        Boolean isPublic
) {
    public ArticleDto addWriteTimestamp(Instant writeTimestamp) {
        return new ArticleDto(id, title, content, writeTimestamp, isPublic);
    }
}
