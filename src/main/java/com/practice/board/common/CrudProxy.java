package com.practice.board.common;

public abstract class CrudProxy<V> implements Proxy<V> {
    protected CrudProxy<V> next;

    public abstract V create(Object... args);
    public abstract V read(Object... args);
    public abstract V update(Object... args);
    public abstract void delete(Object... args);

    public void setNext(CrudProxy<V> next) {
        this.next = next;
    }

    protected V proceedCreate(Object... args) {
        return next != null ? next.create(args) : null;
    }

    protected V proceedRead(Object... args) {
        return next != null ? next.read(args) : null;
    }

    protected V proceedUpdate(Object... args) {
        return next != null ? next.update(args) : null;
    }

    protected void proceedDelete(Object... args) {
        if (next != null) next.delete(args);
    }

    @Override
    public void addProxy(Proxy<V> next) {
        if (this.next == null && next instanceof CrudProxy) this.next = (CrudProxy<V>) next;
        else {
            assert this.next != null;
            this.next.addProxy(next);
        }
    }
}