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
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userService.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Stream.of(SecurityUtils.convertToAuthority(user.getRole().name())).collect(Collectors.toSet());
                //Collections.singleton(SecurityUtils.convertToAuthority(user.getRole().name())); inmutable In general,
                //an immutable object will not change its internal state once we create it. This makes it thread-safe by default
                //Stream.of(SecurityUtils.convertToAuthority(user.getRole().name())).collect(Collectors.toSet());
                // https://logfetch.com/java-initialize-set/ set.of java 9 o 11.

        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
