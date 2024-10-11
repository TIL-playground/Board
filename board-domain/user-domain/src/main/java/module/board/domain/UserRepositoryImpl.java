package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.exception.DataNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository repository;
    private final UserDomainMapper mapper;

    @Override
    public UserDto getById(final Long id) {
        final var entity = repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("일치하는 유저를 찾지 못했습니다."));

        return mapper.toDto(entity);
    }

    @Override
    public UserDto getByEmail(final String email) {
        final var entity = repository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException("해당 이메일과 일치하는 유저를 찾지 못했습니다."));

        return mapper.toDto(entity);
    }

    @Override
    public List<UserDto> searchByNickname(final String input, final int page, final int size) {
        final var entities = repository.findByNicknameContains(input, PageRequest.of(page, size));

        return mapper.toDtos(entities);
    }

    @Override
    public UserDto getByNickname(final String nickname) {
        final var entity = repository.findByNickname(nickname).orElseThrow();

        return mapper.toDto(entity);
    }

    @Override
    public UserDto save(final UserDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public boolean existsByEmail(final String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByNickname(final String nickname) {
        return repository.existsByNickname(nickname);
    }
}
