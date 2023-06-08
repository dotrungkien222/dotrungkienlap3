package com.example.demo.validator;

import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserService;
import com.example.demo.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(userRepository == null)
            return true;
        return userRepository.findUsername(username) == null;
    }
}
