package com.example.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String username, String password) {
        // In a real-world scenario, you'd check the credentials against a database
        return "student".equals(username) && "Password123".equals(password);
    }
}
