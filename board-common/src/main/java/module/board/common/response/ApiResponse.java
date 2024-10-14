package module.board.common.response;

import module.board.common.http.HttpStatusUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public record ApiResponse<T>(
        boolean success,
        int status,
        String message,
        T data,
        long timestamp,
        String path
) {
    private static final Instant TIMESTAMP = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();

    public static <T> ApiResponse<T> success(HttpStatusUtil status, T data, String path) {
        return new ApiResponse<>(true, status.code(), status.message(), data, TIMESTAMP.toEpochMilli(), path);
    }

    public static <T> ApiResponse<T> success(HttpStatusUtil status, String path) {
        return new ApiResponse<>(true, status.code(), status.message(), null, TIMESTAMP.toEpochMilli(), path);
    }

    public static <T> ApiResponse<T> error(int status, String message, String path) {
        return new ApiResponse<>(false, status, message, null, TIMESTAMP.toEpochMilli(), path);
    }
}
