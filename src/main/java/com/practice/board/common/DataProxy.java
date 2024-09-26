package com.practice.board.common;

public interface DataProxy<V> extends Proxy<V> {
    V save(Object... args);
    V get(Object... args);
    void delete(Object... args);
}
