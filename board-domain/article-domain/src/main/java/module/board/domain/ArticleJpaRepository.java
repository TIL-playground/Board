package module.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface ArticleJpaRepository extends JpaRepository<Article, Long> {
}
