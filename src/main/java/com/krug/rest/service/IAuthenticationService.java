package com.krug.rest.service;

import com.krug.rest.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
