package lk.ijse.edu.config;

import lk.ijse.edu.bean.BeanC;
import lk.ijse.edu.bean.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }
}
