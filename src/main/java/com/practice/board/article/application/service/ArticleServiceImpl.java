package com.practice.board.article.application.service;

import com.practice.board.article.domain.ArticleDto;
import com.practice.board.article.domain.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    @Override
    public ArticleDto save(final ArticleDto dto) {
        return repository.save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleDto get(final Long id) {
        return repository.getById(id);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
