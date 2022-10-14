package com.krug.rest.serviceimp;

import com.krug.rest.model.Rol;
import com.krug.rest.model.User;
import com.krug.rest.repositry.IUserRepository;
import com.krug.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     user.setRole(Rol.USER);
     return userRepository.save(user);
    }
    @Override
    public Optional<User> findByUserName(String username){
        return userRepository.findByUserName(username);
    }
    @Override
    @Transactional  //TransaccionalRequired when executing on update/delete query.
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, Rol.ADMIN);
    }
}
