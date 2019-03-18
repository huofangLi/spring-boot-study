package com.springboot.quickstart.controller;

/*SpringBoot的第一个RESTful请求*/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)/*映射一个请求*/
    public String getHello() {
        return "Hello Spring Boot";
    }
}
