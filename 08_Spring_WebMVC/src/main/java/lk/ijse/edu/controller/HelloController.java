package lk.ijse.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController Constructor");
    }

    @GetMapping()
    public String hello() {
        return "index";
    }

//    @GetMapping("one")
//    public String hello1() {
//        return "Hello, World1!";
//    }

//    @GetMapping("two")
//    public String hello2() {
//        return "Hello, World2!";
//    }
}
