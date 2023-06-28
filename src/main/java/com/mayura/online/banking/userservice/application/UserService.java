package com.mayura.online.banking.userservice.application;

import com.mayura.online.banking.userservice.domain.User;
import com.mayura.online.banking.userservice.infarstructure.persistent.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String id) {
        Optional<User> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

    public String create(User user){
        return userRepository.save(user).getId();
    }
}
