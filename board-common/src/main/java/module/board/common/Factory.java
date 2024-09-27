package module.board.common;

public interface Factory<V> {
    Proxy<V> get();
}