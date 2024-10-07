package module.board.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<ArticleDto> getAll(int page, int size) {
        final var entities = repository.findAll(PageRequest.of(page, size));

        return entities.stream()
                .map(mapper::toDto)
                .toList();
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
