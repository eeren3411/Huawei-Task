package com.demo.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class testController {
    
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World!";
    }
}
