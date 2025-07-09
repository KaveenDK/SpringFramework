package lk.ijse.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exact")
public class ExactMappingController {
    @GetMapping(path = "/hello")
    public String sayHello() {
        return "Hello from ExactMappingController!";
    }

    @GetMapping(path = "/hello/two")
    public String sayHelloGet() {
        return "Hello from ExactMappingController - Two!";
    }

    @GetMapping(path = "/hello/two/api")
    public String sayHelloPost() {
        return "Hello from ExactMappingController - Two API!";
    }
}
