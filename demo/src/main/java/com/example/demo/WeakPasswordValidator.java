package com.example.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeakPasswordValidator implements ConstraintValidator<WeakPassword,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() > 10;
    }

    @Override
    public void initialize(WeakPassword constraintAnnotation) {

    }
}
