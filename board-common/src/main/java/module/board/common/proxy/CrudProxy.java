package module.board.common.proxy;

public abstract class CrudProxy<V> implements Proxy<V> {
    private CrudProxy<V> next;

    public abstract V create(Object... args);
    public abstract Object read(Object... args);
    public abstract V update(Object... args);
    public abstract void delete(Object... args);

    protected V proceedCreate(Object... args) {
        return next != null ? next.create(args) : null;
    }

    protected Object proceedRead(Object... args) {
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
        if (this.next == null && next instanceof CrudProxy) {
            this.next = (CrudProxy<V>) next;
        } else if (this.next != null) {
            this.next.addProxy(next);
        } else {
            throw new IllegalArgumentException("잘못된 프록시 객체를 파라미터로 사용했습니다.");
        }
    }
}