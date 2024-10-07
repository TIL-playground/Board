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
    public Object get(final Object... arg) {
        final var result = handler.get(arg);

        if (result instanceof List) {
            return ((List<module.board.domain.ArticleDto>) result).stream()
                    .map(mapper::toDto)
                    .toList();
        }

        return mapper.toDto((module.board.domain.ArticleDto) result);
    }

    @Override
    public void delete(final Long id) {
        handler.delete(id);
    }
}
