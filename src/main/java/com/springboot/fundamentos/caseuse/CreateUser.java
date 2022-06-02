package com.springboot.fundamentos.caseuse;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.create(user);
    }
}
