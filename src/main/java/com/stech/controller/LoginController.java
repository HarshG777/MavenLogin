package com.example.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Returns login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isValidUser = loginService.validateUser(username, password);
        if (isValidUser) {
            model.addAttribute("message", "Logged In Successfully");
            return "home";  // Returns home.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";  // Returns login.html
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";  // Returns home.html
    }
}
