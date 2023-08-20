package com.kirito.test.security;

import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 鉴权异常响应
 *
 * @author 公众号:知了一笑
 * @since 2023-07-23 14:24
 */
@Component
public class AuthExeHandler implements AuthenticationEntryPoint, Ordered {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException {
        ResponseEntity<String> rep = ResponseEntity.ok(HttpStatus.UNAUTHORIZED.value() + HttpStatus.UNAUTHORIZED.getReasonPhrase());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.write(new JsonMapper().writeValueAsString(rep));
        out.flush();
        out.close();
    }

    @Override
    public int getOrder() {
        return 9999;
    }
}