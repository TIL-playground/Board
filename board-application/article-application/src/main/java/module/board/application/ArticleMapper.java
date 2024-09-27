package module.board.application;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ArticleMapper {
    ArticleDto toDto(module.board.domain.ArticleDto dto);
    module.board.domain.ArticleDto toDomainDto(ArticleDto dto);
}
