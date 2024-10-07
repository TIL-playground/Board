package module.board.domain;

import java.util.List;

interface ArticleRepository {
    ArticleDto getById(Long id);
    List<ArticleDto> getAll(int page, int size);
    ArticleDto save(ArticleDto article);
    void deleteById(Long id);
}
