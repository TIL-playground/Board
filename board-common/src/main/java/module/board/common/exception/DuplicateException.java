package module.board.common.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException() {
        super();
    }

    public DuplicateException(final String message) {
        super(message);
    }

    public DuplicateException(final Throwable throwable) {
        super(throwable);
    }

    public DuplicateException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
