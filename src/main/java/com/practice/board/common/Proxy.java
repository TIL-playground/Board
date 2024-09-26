package com.practice.board.common;

public interface Proxy<V> {
    void addProxy(Proxy<V> proxy);
}
