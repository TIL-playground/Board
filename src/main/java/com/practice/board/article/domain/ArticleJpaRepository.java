package com.practice.board.article.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface ArticleJpaRepository extends JpaRepository<Article, Long> {
}
