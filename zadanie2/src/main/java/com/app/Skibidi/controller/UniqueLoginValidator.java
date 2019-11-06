package com.app.Skibidi.controller;

import com.app.Skibidi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginValidator implements ConstraintValidator<com.app.Skibidi.controller.UniqueLogin, String> {

    private UserRepository userRepository;

    @Autowired
    public UniqueLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UniqueLoginValidator(){

    }
    public void initialize(com.app.Skibidi.controller.UniqueLogin constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        boolean isOk = true;
        if (userRepository.findByUsername(login).orElse(null) != null)
            isOk=false;
        return login != null && isOk;

    }

}