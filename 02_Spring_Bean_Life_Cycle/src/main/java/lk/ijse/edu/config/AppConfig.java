package lk.ijse.edu.config;

import lk.ijse.edu.bean.MyConnection;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "lk.ijse.edu.bean")
public class AppConfig {
    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Default scope is singleton
    MyConnection getConnection() {
        System.out.println("Creating MyConnection bean");
        return new MyConnection();
    }
}
