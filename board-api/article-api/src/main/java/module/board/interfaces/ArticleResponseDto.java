package module.board.interfaces;

import java.time.Instant;

record ArticleResponseDto(
        String id,
        String title,
        String content,
        Instant writeTimestamp,
        Boolean isPublic
) {
}
