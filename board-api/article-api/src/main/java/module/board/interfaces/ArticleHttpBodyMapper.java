package module.board.interfaces;

import module.board.application.ArticleDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface ArticleHttpBodyMapper {
    ArticleDto toDto(ArticleRequestDto dto);
    ArticleResponseDto toResponse(ArticleDto dto);
}
