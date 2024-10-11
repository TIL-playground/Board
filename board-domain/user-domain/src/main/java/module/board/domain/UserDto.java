package module.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDto(
        Long id,
        String nickname,
        String email,
        @JsonIgnore
        String password
) {
}
