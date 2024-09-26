package com.practice.board.common;

public interface Factory<V> {
    Proxy<V> get();
}