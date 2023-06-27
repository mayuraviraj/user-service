package com.mayura.online.banking.userservice.infarstructure.web;

import com.mayura.online.banking.userservice.application.UserService;
import com.mayura.online.banking.userservice.util.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User controller mainly controller the action on users.
 */
@RestController
@RequestMapping("users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserVO> getUser(@PathVariable(name = "userId") final Long userId) {
        log.info("Finding user with id {}", userId);
        return new ResponseEntity<>(UserConverter.toUserValueObject(userService.getUserById(userId)),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserVO user){
        log.info("Creating new user with id {}", user.extId());
        Long id = userService.create(UserConverter.toUserDomainObject(user));
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
