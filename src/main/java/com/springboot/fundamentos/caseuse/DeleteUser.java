package com.springboot.fundamentos.caseuse;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public boolean remove(Long id) {
        try {
            userService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
