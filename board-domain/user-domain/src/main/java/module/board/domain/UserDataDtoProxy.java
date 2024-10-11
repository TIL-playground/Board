package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.DataProxy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserDataDtoProxy extends DataProxy<UserDto> {
    private final UserRepository repository;

    @Override
    public UserDto save(final Object... args) {
        if (args.length == 1 && args[0] instanceof UserDto) {
            return repository.save((UserDto) args[0]);
        }

        return proceedSave(args);
    }

    @Override
    public Object get(final Object... args) {
        return proceedGet(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
