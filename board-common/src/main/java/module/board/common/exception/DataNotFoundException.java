package module.board.common.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(final String message) {
        super(message);
    }

    public DataNotFoundException(final Throwable throwable) {
        super(throwable);
    }

    public DataNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
