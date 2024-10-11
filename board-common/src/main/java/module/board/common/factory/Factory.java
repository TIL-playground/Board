package module.board.common.factory;

import module.board.common.proxy.Proxy;

public interface Factory<V> {
    Proxy<V> get();
}