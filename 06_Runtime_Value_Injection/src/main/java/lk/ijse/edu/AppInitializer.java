package lk.ijse.edu;

import lk.ijse.edu.bean.SpringBean;
import lk.ijse.edu.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println("Bean Retrieved: " + bean);

        context.registerShutdownHook();
    }
}