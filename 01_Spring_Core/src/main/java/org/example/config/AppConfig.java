package org.example.config;

import org.example.bean.MyConnection;
import org.example.test.TestBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
//@ComponentScan(basePackageClasses = SpringBean.class)
//@ComponentScan(basePackageClasses = TestBean1.class)
public class AppConfig {
//    @Bean //pitin ganan class akak akak bean akak karanna use karai
//    MyConnection myConnection() {
//        return new MyConnection();
//    }

    @Bean("san")
    MyConnection getConnection() {
        return new MyConnection();
    }
}
