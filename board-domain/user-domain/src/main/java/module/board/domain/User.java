package module.board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@Table(name = "board_user")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String nickname;

    @Column(length = 200, unique = true)
    private String email;

    @Column(length = 500)
    private String password;

    protected User() {}
}
