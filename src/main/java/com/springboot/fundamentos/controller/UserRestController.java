package com.springboot.fundamentos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.fundamentos.caseuse.CreateUser;
import com.springboot.fundamentos.caseuse.DeleteUser;
import com.springboot.fundamentos.caseuse.GetUser;
import com.springboot.fundamentos.caseuse.UpdateUser;
import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.repository.UserRepository;
import com.springboot.fundamentos.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    // create, get, remove, update
    private GetUser getUser;
    private CreateUser createUser;
    private UpdateUser updateUser;
    private DeleteUser deleteUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser,
                              CreateUser createUser,
                              UpdateUser updateUser,
                              DeleteUser deleteUser,
                              UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
        this.userRepository = userRepository;
    }

    @GetMapping
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping()
    ResponseEntity<User> postUser(@RequestBody User user) {
        return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<User> putUser(@RequestBody User user,
                                 @PathVariable Long id) {
        return new ResponseEntity<>(updateUser.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<ObjectNode> deleteUser(@PathVariable Long id) {
        String[] msg = {
                "Deleted user",
                "Try again - verify param"
        };

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();

        return deleteUser.remove(id)
                ? ResponseEntity.status(HttpStatus.OK).body(objectNode.put("message", msg[0]))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectNode.put("message", msg[1]));
    }

    @GetMapping("/pageable")
    Page getUserPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
