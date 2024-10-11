package module.board.common.proxy;

public interface Proxy<V> {
    void addProxy(Proxy<V> proxy);
}
