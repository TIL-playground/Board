package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.proxy.DataProxy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserDataLongProxy extends DataProxy<UserDto> {
    private final UserRepository repository;

    @Override
    public UserDto save(final Object... args) {
        return proceedSave(args);
    }

    @Override
    public Object get(final Object... args) {
        if (args.length == 0 && args[0] instanceof Long) {
            return repository.getById((Long) args[0]);
        }

        return proceedGet(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
