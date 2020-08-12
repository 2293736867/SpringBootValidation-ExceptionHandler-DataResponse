package com.example.demo;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService service;
    @PostMapping("test")
    public String test(@RequestBody User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(t->System.out.println(t.getDefaultMessage()));
            for(ObjectError error:bindingResult.getAllErrors())
                return error.getDefaultMessage();
        }
        return service.test(user);
    }
}
