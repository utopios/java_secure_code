package com.example.correction_tps.controller;

import com.example.correction_tps.entity.User;
import com.example.correction_tps.service.PasswordService;
import com.example.correction_tps.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final UserService userService;
    private final PasswordService passwordService;
    public AuthController(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);

        if (user != null && !user.isLocked()) {
            if (passwordService.matchesPassword(password, user.getPassword())) {
                user.resetFailedAttempts();  // Reset failed attempts on successful login
                userService.save(user);
                return "home";  // Successful authentication
            } else {
                user.incrementFailedAttempts();  // Increase failed attempts on incorrect login
                userService.save(user);
                if (user.isLocked()) {
                    return "accountLocked";  // Redirect to account locked page
                }
            }
        }
        return "login";
    }

}
