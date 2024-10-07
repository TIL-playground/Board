package module.board.application;

interface ArticleService {
    ArticleDto save(ArticleDto dto);
    Object get(Object... arg);
    void delete(Long id);
}