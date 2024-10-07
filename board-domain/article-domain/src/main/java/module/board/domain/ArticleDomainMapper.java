package module.board.domain;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface ArticleDomainMapper {
    ArticleDto toDto(Article entity);
    Article toEntity(ArticleDto dto);
}
