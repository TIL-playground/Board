package module.board.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ArticleRepositoryImpl implements ArticleRepository {
    private final ArticleJpaRepository repository;
    private final ArticleDomainMapper mapper;

    @Override
    public ArticleDto getById(final Long id) {
        final var entity = repository.findById(id).orElseThrow();

        return mapper.toDto(entity);
    }

    @Override
    public ArticleDto save(final ArticleDto article) {
        final var entity = mapper.toEntity(article);
        final var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
