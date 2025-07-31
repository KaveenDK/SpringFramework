package lk.ijse.edu.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/21/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String helloUser() {
        return "Hello, User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin() {
        return "Hello, Admin!";
    }
}
