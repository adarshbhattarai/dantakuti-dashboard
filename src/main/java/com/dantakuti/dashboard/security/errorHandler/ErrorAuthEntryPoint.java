package com.dantakuti.dashboard.security.errorHandler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adarshbhattarai on 2019-06-20
 * @project dashboard
 */
@Component
public class ErrorAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("Unsuccessful Authorization");
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
    }
}
