package module.board.domain;

import java.util.List;

interface UserRepository {
    UserDto getById(Long id);
    UserDto getByEmail(String email);
    UserDto getByNickname(String nickname);
    List<UserDto> searchByNickname(String input, int page, int size);
    UserDto save(UserDto dto);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
