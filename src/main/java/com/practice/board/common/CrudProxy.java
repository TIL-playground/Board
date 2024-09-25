package com.practice.board.common;

public interface CrudProxy<V> {
    V create(Object... args);
    V read(Object... args);
    V update(Object... args);
    void delete(Object... args);
    void addProxy(CrudProxy<V> crudProxy);
}