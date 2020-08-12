package com.example.demo;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService service;
    private final FailFastValidator<User> validator;
    @PostMapping("test")
    public String test(@RequestBody User user, BindingResult bindingResult)
    {
        Set<ConstraintViolation<User>> message = validator.validate(user);
        message.forEach(t-> System.out.println(t.getMessage()));
//        if(bindingResult.hasErrors())
//        {
//            bindingResult.getAllErrors().forEach(t->System.out.println(t.getDefaultMessage()));
//            for(ObjectError error:bindingResult.getAllErrors())
//                return error.getDefaultMessage();
//        }
        return service.test(user);
    }
}
