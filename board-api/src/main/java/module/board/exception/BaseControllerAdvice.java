package module.board.exception;

import lombok.extern.slf4j.Slf4j;
import module.board.common.error.ErrorResponse;
import module.board.common.exception.BadRequestException;
import module.board.common.exception.DataNotFoundException;
import module.board.common.exception.DuplicateException;
import module.board.common.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {
    public static final Instant TIMESTAMP = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noHandlerFoundException(final NoHandlerFoundException ex) {
        log.debug(ex.getMessage(), ex.getCause());
        return ErrorResponse.newResponse(HttpStatus.NOT_FOUND.value(), "존재하지 않는 API 엔드포인트로 요청을 보내셨습니다. 요청 내용을 다시 확인해주세요.", TIMESTAMP);
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noHandlerFoundException(final Exception ex) {
        return ErrorResponse.newResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler({BadRequestException.class, DuplicateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(final Exception ex) {
        return ErrorResponse.newResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse notSupportedException(final HttpRequestMethodNotSupportedException ex) {
        log.debug(ex.getMessage(), ex.getCause());
        return ErrorResponse.newResponse(HttpStatus.METHOD_NOT_ALLOWED.value(),"허용되지 않은 메서드로 요처을 하셨습니다. 요청 내용을 다시 확인해주세요.", TIMESTAMP);
    }

    @ExceptionHandler({Exception.class, ServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllExceptions(final Exception ex) {
        log.error(ex.getMessage(), ex.getLocalizedMessage());
        return ErrorResponse.newResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), TIMESTAMP);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptionHandler(final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ErrorResponse.newResponse(HttpStatus.BAD_REQUEST.value(), errors.toString(), TIMESTAMP);
    }
}