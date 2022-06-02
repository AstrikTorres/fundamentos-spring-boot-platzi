package com.springboot.fundamentos.controller;

import com.springboot.fundamentos.caseuse.GetUser;
import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    // create, get, delete, update
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping
    List<User> get() {
        return getUser.getAll();
    }

}
