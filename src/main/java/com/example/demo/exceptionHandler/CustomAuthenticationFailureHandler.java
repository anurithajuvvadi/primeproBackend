package com.example.demo.exceptionHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException, ServletException {
        if (exception instanceof BadCredentialsException) {
            System.out.println("Bad credential ");
            // Handle bad credentials exception (e.g., log or respond with a specific error message)
            response.sendRedirect("/auth/login?error=bad_credentials");
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
