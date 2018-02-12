package com.djsk.challenges.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Now after logout, instead 404 code we have 200 code, 404 code were received after unsuccessful redirection to non-existing site
@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler
        implements LogoutSuccessHandler {

    CustomLogoutSuccessHandler() {
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
    }
}