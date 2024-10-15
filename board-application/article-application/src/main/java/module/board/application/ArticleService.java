package module.board.application;

import java.util.List;

interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto getOne(Object... args);
    List<ArticleDto> getAll(Object... args);
    void delete(Long id);
}