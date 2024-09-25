package com.practice.board.common;

import com.practice.board.common.CrudProxy;

public interface CrudFactory<V> {
    CrudProxy<V> get();
}