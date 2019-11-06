package com.app.Skibidi.controller;

import com.app.Skibidi.model.User;
import com.app.Skibidi.repository.RoleRepository;
import com.app.Skibidi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MainController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {

        User n = new User();
        n.setUsername(name);
        n.setEmail(email);
        n.setPassword(passwordEncoder.encode(password));
        n.setEnabled((byte) 1);
        n.setRole(roleRepository.findById(1).orElse(null));
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
