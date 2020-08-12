package com.example.demo;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService service;
    private final WeakPasswordValidator validator;
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.setValidator(validator);
    }

    @PostMapping("test")
    public String test(@RequestBody @Validated({User.Group.class}) User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(t-> System.out.println(t.getCode()));
            for(ObjectError error:bindingResult.getAllErrors())
                return error.getCode();
        }
        return service.test(user);
    }
}
