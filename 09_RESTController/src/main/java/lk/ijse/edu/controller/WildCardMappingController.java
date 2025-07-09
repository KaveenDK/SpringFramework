package lk.ijse.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wildcard")
public class WildCardMappingController {

    //one/test/hello
    @GetMapping("test/*/hello")
    public String sayHello() {
        return "Hello from WildCardMappingController!";
    }

//    @GetMapping("hello/**/ijse")
//    public String sayHelloPost() {
//        return "Hello from WildCardMappingController - Three!";
//    }

    @GetMapping("hello/*/*")
    public String sayHelloGet() {
        return "Hello from WildCardMappingController - Two!";
    }
}
