package module.board.domain;

import module.board.common.proxy.DataProxy;
import module.board.common.factory.Factory;
import org.springframework.stereotype.Component;

@Component
class UserDataFactory implements Factory<UserDto> {
    private final DataProxy<UserDto> dataProxy;

    private UserDataFactory(final UserDataProxy dataProxy, final UserDataLongProxy longProxy, final UserDataDtoProxy dtoProxy) {
        dataProxy.addProxy(longProxy);
        dataProxy.addProxy(dtoProxy);
        this.dataProxy = dataProxy;
    }

    @Override
    public DataProxy<UserDto> get() {
        return dataProxy;
    }
}
