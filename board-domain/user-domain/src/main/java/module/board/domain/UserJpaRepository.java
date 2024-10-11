package module.board.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    List<User> findByNicknameContains(String input, PageRequest request);

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
