package module.board.common.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super();
    }

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final Throwable throwable) {
        super(throwable);
    }

    public BadRequestException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
