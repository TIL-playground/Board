package module.board.interfaces;

import module.board.application.ArticleDto;
import module.board.common.hash.HashUtil;

import java.time.Instant;

record ArticleResponseDto(
        String id,
        String title,
        String content,
        Instant writeTimestamp,
        Boolean isPublic
) {
    public static ArticleResponseDto fromArticleDto(final ArticleDto dto) {
        return new ArticleResponseDto(
                HashUtil.encode(dto.id()),
                dto.title(),
                dto.content(),
                dto.writeTimestamp(),
                dto.isPublic()
        );
    }
}
