package com.demo.springboot.controllers;

import com.demo.springboot.dto.HelloDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.POST)
    public HelloDTO saySpecialHelloByName(@RequestBody HelloDTO body) {

        body.setMessage("Hello World from Spring Boot");
        return body;
    }

}
