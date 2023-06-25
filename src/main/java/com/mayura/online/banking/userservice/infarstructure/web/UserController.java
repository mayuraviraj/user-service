package com.mayura.online.banking.userservice.infarstructure.web;

import com.mayura.online.banking.userservice.application.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller mainly controller the action on users.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    UserVO getUser(final String id) {
        System.out.println("==============");
        return userService.getUserById(id);
    }
}
