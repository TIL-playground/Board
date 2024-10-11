package module.board.common.proxy;

public interface ProxyHandler<T> {
    T save(Object... args);
    Object get(Object... args);
    void delete(Object... args);
}
