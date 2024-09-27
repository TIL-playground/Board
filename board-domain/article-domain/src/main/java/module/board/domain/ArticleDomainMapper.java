package module.board.domain;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ArticleDomainMapper {
    ArticleDto toDto(Article entity);
    Article toEntity(ArticleDto dto);
}
