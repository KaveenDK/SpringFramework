package lk.ijse.edu;

import lk.ijse.edu.bean.Boy;
import lk.ijse.edu.config.AppConfig;
import lk.ijse.edu.di.Test2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        Boy boy = context.getBean(Boy.class);
//        System.out.println(boy);
//        boy.chatWithGirl();

        Test2 test2 = context.getBean(Test2.class);
        test2.calledHelloMethod();

        context.registerShutdownHook();
    }
}