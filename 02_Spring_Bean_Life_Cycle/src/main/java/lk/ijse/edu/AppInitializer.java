package lk.ijse.edu;

import lk.ijse.edu.bean.MyConnection;
import lk.ijse.edu.bean.SpringBean;
import lk.ijse.edu.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        SpringBean bean1 = context.getBean(SpringBean.class);
//        System.out.println(bean1);
//
//        SpringBean bean2 = context.getBean(SpringBean.class);
//        System.out.println(bean2);

//        MyConnection myConnection1 = context.getBean(MyConnection.class);
//        System.out.println(myConnection1);
//        MyConnection myConnection2 = context.getBean(MyConnection.class);
//        System.out.println(myConnection2);

        MyConnection myConnection1 = context.getBean(MyConnection.class);
        MyConnection myConnection2 = context.getBean(MyConnection.class);


        context.registerShutdownHook();
    }
}