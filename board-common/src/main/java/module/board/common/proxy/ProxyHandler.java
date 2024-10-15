package module.board.common.proxy;

import java.util.List;

public interface ProxyHandler<T> {
    T save(Object... args);
    T getOne(Object... args);
    List<T> getAll(Object... args);
    void delete(Object... args);
}
