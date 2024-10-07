package module.board.common;

public abstract class DataProxy<V> implements Proxy<V> {
    private DataProxy<V> next;

    public abstract V save(Object... args);
    public abstract Object get(Object... args);
    public abstract void delete(Object... args);

    protected V proceedSave(Object... args) {
        return next != null ? next.save(args) : null;
    }

    protected Object proceedGet(Object... args) {
        return next != null ? next.get(args) : null;
    }

    protected void proceedDelete(Object... args) {
        if (next != null) next.delete(args);
    }

    @Override
    public void addProxy(Proxy<V> next) {
        if (this.next == null && next instanceof DataProxy) this.next = (DataProxy<V>) next;
        else {
            assert this.next != null;
            this.next.addProxy(next);
        }
    }
}
