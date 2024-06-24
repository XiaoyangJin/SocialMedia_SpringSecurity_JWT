package com.springsecurity.security.service;

import com.springsecurity.security.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    User authenticate(String username, String password);
    String generateToken(User user);
}
