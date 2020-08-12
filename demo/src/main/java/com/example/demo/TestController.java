package com.example.demo;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService service;

    @PostMapping("test")
    public String test(@RequestBody @Validated({User.Group.class}) User user)
    {
        throw new TestException("出现异常");
//        return service.test(user);
    }
}
