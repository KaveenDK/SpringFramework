package lk.ijse.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.edu.bean", "lk.ijse.edu.controller"})
@EnableWebMvc
public class WebAppConfig {
}
