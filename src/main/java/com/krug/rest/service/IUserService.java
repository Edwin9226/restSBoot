package com.krug.rest.service;

import com.krug.rest.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);
    Optional<User> findByUserName(String username);

    @Transactional
        //TransaccionalRequired when executing on update/delete query.
    void makeAdmin(String username);
}
