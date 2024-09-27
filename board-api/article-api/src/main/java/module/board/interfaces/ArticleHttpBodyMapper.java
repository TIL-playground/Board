package module.board.interfaces;

import module.board.application.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ArticleHttpBodyMapper {
    ArticleDto toDto(ArticleRequestDto dto);
    ArticleResponseDto toResponse(ArticleDto dto);
}
