package module.board.domain;

import module.board.common.DataProxy;
import org.springframework.stereotype.Component;

@Component
class UserDomainProxyHandlerImpl implements UserDomainProxyHandler {
    private final DataProxy<UserDto> dataProxy;

    private UserDomainProxyHandlerImpl(final UserDataFactory factory) {
        dataProxy = factory.get();
    }

    @Override
    public UserDto save(final Object... args) {
        return dataProxy.save(args);
    }

    @Override
    public Object get(final Object... args) {
        return dataProxy.get(args);
    }

    @Override
    public void delete(final Object... args) {
        dataProxy.delete(args);
    }
}
