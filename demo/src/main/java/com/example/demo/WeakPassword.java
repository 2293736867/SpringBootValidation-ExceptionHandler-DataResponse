package com.example.demo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WeakPasswordValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WeakPassword{
    String message() default "请使用更加强壮的密码";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
