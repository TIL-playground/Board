package module.board.common.exception;

public class ServerException extends RuntimeException {
    public ServerException() {
        super();
    }

    public ServerException(final String message) {
        super(message);
    }

    public ServerException(final Throwable throwable) {
        super(throwable);
    }

    public ServerException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
