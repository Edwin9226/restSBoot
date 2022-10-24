package com.krug.rest.security;

import com.krug.rest.model.User;
import com.krug.rest.service.IUserService;
import com.krug.rest.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userService.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities= Stream.of(SecurityUtils.convertToAuthority(user.getRole().name())).collect(Collectors.toSet());

        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
