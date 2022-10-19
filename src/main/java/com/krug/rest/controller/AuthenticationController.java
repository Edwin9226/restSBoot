package com.krug.rest.controller;

import com.krug.rest.model.User;
import com.krug.rest.service.IAuthenticationService;
import com.krug.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")//api/authentication/sign-up
    public ResponseEntity<User> signUp(@RequestBody User user){
        if(userService.findByUserName(user.getUsername()).isPresent()){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return  new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user){
        return  new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),HttpStatus.OK);
    }
}
