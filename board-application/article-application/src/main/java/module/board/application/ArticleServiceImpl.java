package module.board.application;

import lombok.RequiredArgsConstructor;
import module.board.domain.ArticleDomainProxyHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ArticleServiceImpl implements ArticleService {
    private final ArticleDomainProxyHandler handler;
    private final ArticleMapper mapper;

    @Override
    public ArticleDto save(final ArticleDto dto) {
        final var domainDto = handler.save(mapper.toDomainDto(dto));

        return mapper.toDto(domainDto);
    }

    @Override
    public ArticleDto getOne(final Object... args) {
        final var result = handler.getOne(args);

        return mapper.toDto(result);
    }

    @Override
    public List<ArticleDto> getAll(final Object... args) {
        final var result = handler.getAll(args);

        return result.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void delete(final Long id) {
        handler.delete(id);
    }
}
