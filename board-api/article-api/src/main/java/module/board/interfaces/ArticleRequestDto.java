package module.board.interfaces;

import jakarta.annotation.Nullable;

record ArticleRequestDto(
        @Nullable Long id,
        String title,
        String content,
        Boolean isPublic
) {
    public ArticleRequestDto addId(final Long id) {
        return new ArticleRequestDto(id, title, content, isPublic);
    }
}
