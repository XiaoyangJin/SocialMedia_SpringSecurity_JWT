package com.springsecurity.SocialMedia.service;

import com.springsecurity.SocialMedia.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    User authenticate(String username, String password);
    String generateToken(User user);
}
