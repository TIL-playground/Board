package module.board.application;

interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto get(Long id);
    void delete(Long id);
}