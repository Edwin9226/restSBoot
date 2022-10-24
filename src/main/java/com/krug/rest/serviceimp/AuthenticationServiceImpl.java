package com.krug.rest.serviceimp;

import com.krug.rest.model.User;
import com.krug.rest.security.UserPrincipal;
import com.krug.rest.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User signInAndReturnJWT(User signInRequest)
    {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );

        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();
        User signInUser = userPrincipal.getUser();
        signInUser.setToken(null); 
        return signInUser;
    }
}
