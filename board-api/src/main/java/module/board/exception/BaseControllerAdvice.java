package module.board.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import module.board.common.exception.BadRequestException;
import module.board.common.exception.DataNotFoundException;
import module.board.common.exception.DuplicateException;
import module.board.common.exception.ServerException;
import module.board.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> noHandlerFoundException(final NoHandlerFoundException ex, final HttpServletRequest request) {
        log.debug(ex.getMessage(), ex.getCause());
        return ApiResponse.error(
                HttpStatus.NOT_FOUND.value(),
                "존재하지 않는 API 엔드포인트로 요청을 보내셨습니다. 요청 내용을 다시 확인해주세요.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> noHandlerFoundException(final Exception ex, final HttpServletRequest request) {
        return ApiResponse.error(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler({BadRequestException.class, DuplicateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleBadRequestException(final Exception ex, final HttpServletRequest request) {
        return ApiResponse.error(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiResponse<Void> notSupportedException(final HttpRequestMethodNotSupportedException ex, final HttpServletRequest request) {
        log.debug(ex.getMessage(), ex.getCause());
        return ApiResponse.error(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "허용되지 않은 메서드로 요처을 하셨습니다. 요청 내용을 다시 확인해주세요.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler({Exception.class, ServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleAllExceptions(final Exception ex, final HttpServletRequest request) {
        log.error(ex.getMessage(), ex.getLocalizedMessage());
        return ApiResponse.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> handleValidationExceptionHandler(final MethodArgumentNotValidException ex, final HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ApiResponse.error(
                HttpStatus.BAD_REQUEST.value(),
                errors.toString(),
                request.getRequestURI()
        );
    }
}