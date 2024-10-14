package module.board.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import module.board.common.http.HttpStatusUtil;
import module.board.common.response.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
        response.setStatus(HttpStatusUtil.FORBIDDEN.code());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        
        final ApiResponse<Void> apiResponse = ApiResponse.error(
                HttpStatusUtil.FORBIDDEN.code(),
                "Access Denied: No valid token provided",
                request.getRequestURI()
        );
        
        objectMapper.writeValue(response.getWriter(), apiResponse);
    }
}