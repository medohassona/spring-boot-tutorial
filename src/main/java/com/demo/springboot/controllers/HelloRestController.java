package com.demo.springboot.controllers;

import com.demo.springboot.dto.HelloDTO;
import org.springframework.web.bind.annotation.*;

// url = localhost:8080/rest/special
// uri (path) = /rest/special

@RestController
@RequestMapping("/rest")
public class HelloRestController {

    @GetMapping
    public String sayHello() {
        return "Hello World from Rest Contro with devtools";
    }

    @GetMapping("/special")
    public HelloDTO saySpecialHello() {
        HelloDTO dto = new HelloDTO("ahmed", "Hello World from Spring Boot");
        return dto;
    }

    // path variable
    @GetMapping("/special/{name}/hello/{message}")
    public HelloDTO saySpecialHelloByName(@PathVariable(name = "name") String name, @PathVariable(name = "message") String message) {

        HelloDTO dto = new HelloDTO(name, message);
        return dto;
    }

    // request param
    @GetMapping("/special/request")
    public HelloDTO saySpecialHelloByRequestParam(@RequestParam(name = "name") String name, @RequestParam(name = "message") String message) {

        HelloDTO dto = new HelloDTO(name, message);
        return dto;
    }


    @PostMapping
    public HelloDTO saySpecialHelloByName(@RequestBody HelloDTO body) {

        body.setMessage("Hello World from Spring Boot");
        return body;
    }

}
