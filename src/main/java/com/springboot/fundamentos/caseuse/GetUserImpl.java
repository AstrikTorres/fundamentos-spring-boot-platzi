package com.springboot.fundamentos.caseuse;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserImpl implements GetUser {
    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
