package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class WeakPasswordValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"password","password.empty");
        User user = (User)o;
        if(user.getPassword().length() <= 10)
            errors.rejectValue("password","Password is not strong enough!");
    }
}
