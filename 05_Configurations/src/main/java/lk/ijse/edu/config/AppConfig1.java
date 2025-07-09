package lk.ijse.edu.config;

import lk.ijse.edu.bean.BeanA;
import lk.ijse.edu.bean.BeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanB beanB() {
        return new BeanB();
    }
}
