package com.springsecurity.security.service.impl;

import com.springsecurity.security.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private Map<String, UserDetails> users = new HashMap<>();

    public MyUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        users.put("user", new User("user", passwordEncoder.encode("userpassword"), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));
        users.put("admin", new User("admin", passwordEncoder.encode("adminpassword"), Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
