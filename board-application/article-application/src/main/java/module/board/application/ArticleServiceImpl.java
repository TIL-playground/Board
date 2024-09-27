package module.board.application;

import lombok.RequiredArgsConstructor;
import module.board.domain.ArticleDomainProxyHandler;
import org.springframework.stereotype.Service;

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
    public ArticleDto get(final Long id) {
        final var domainDto = handler.get(id);

        return mapper.toDto(domainDto);
    }

    @Override
    public void delete(final Long id) {
        handler.delete(id);
    }
}
