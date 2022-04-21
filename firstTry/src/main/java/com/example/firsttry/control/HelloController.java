package com.example.firsttry.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author river
 */
@RestController
public class HelloController {
   @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }
}
