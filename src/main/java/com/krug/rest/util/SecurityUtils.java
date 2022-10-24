package com.krug.rest.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static final String ROLE_PREFIX="ROLE_";
    public  static final String AUTH_HEADER= "authorization";
    public static final String AUTH_TOKEN_TYPE="Bearer";
    public static final String AUTH_TOKEN_PREFIX= AUTH_TOKEN_TYPE+ " ";

    public  static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole= role.startsWith(ROLE_PREFIX)?role : ROLE_PREFIX + role;
        return  new SimpleGrantedAuthority(formattedRole);

    }

    public static String extractAuthTokenFromRequest(HttpServletRequest request){
        String barerToken= request.getHeader(AUTH_HEADER);
        if(StringUtils.hasLength(barerToken)&& barerToken.startsWith(AUTH_TOKEN_PREFIX))
        {
            return  barerToken.substring(7);
        }
        return null;
    }

}
