package com.graphql.java.persondetails.resolver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hellp {

    @GetMapping("/go")
    public String go(){
        return "Hello";
    }
}
