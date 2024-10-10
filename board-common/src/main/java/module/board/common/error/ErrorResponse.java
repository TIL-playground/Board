package module.board.common.error;

import java.time.Instant;

public record ErrorResponse(
        int code,
        String message,
        Instant timestamp
) {
    public static ErrorResponse newResponse(int code, String message, Instant timestamp) {
        return new ErrorResponse(code, message, timestamp);
    }
}
