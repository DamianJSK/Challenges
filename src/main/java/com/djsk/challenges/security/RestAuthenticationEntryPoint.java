package com.djsk.challenges.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Now dont know for what is this class needed, probably to resolve requests to without jsp views
//@Component
//public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException ) throws IOException {
//        response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
//    }
//}
