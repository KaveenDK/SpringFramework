package lk.ijse.edu.config;

import lk.ijse.edu.bean.SpringBean;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "lk.ijse.edu.bean")
@Import({AppConfig1.class, AppConfig2.class})

//config -> root
//@ImportResource("classpath:hibernate.cfg.xml")

//if not in the root
//@ImportResource("file:absolute-path-of-hibernate.cfg.xml")
public class AppConfig {
    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }
}
