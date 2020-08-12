package com.example.demo;

import com.example.demo.entity.User;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Configuration
public class FailFastValidator<T> {
    private final Validator validator;
    public FailFastValidator()
    {
        validator = Validation.byProvider(HibernateValidator.class).configure()
                .failFast(true).buildValidatorFactory()
                .getValidator();
    }

    public Set<ConstraintViolation<T>> validate(T user)
    {
        return validator.validate(user);
    }
}
