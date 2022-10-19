package com.krug.rest.security.jwt;

import com.krug.rest.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrincipal auth);

    boolean validateToken(HttpServletRequest request);
}
