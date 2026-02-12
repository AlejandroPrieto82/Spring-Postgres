package eci.edu.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eci.edu.postgres.model.User;
import eci.edu.postgres.model.UserDto;
import eci.edu.postgres.repository.UserRepository;
import eci.edu.postgres.exception.UserNotFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    // Inyección por constructor
    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Crear usuario
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException();
        }
    }
}
