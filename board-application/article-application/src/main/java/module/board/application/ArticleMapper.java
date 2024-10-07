package module.board.application;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface ArticleMapper {
    ArticleDto toDto(module.board.domain.ArticleDto dto);
    module.board.domain.ArticleDto toDomainDto(ArticleDto dto);
}
