package com.practice.board.common;

public interface CrudProxy<V> extends Proxy<V> {
    V create(Object... args);
    V read(Object... args);
    V update(Object... args);
    void delete(Object... args);
}