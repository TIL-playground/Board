package com.practice.board.article.interfaces;

import com.practice.board.article.domain.ArticleDto;
import com.practice.board.article.interfaces.http.ArticleRequestDto;
import com.practice.board.article.interfaces.http.ArticleResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ArticleHttpBodyMapper {
    ArticleDto toDto(ArticleRequestDto dto);
    ArticleResponseDto toResponse(ArticleDto dto);
}
