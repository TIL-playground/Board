package module.board.domain;

interface ArticleRepository {
    ArticleDto getById(Long id);
    ArticleDto save(ArticleDto article);
    void deleteById(Long id);
}
