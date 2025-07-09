package org.example;

import org.example.bean.MyConnection;
import org.example.test.TestBean1;
import org.example.bean.TestBean2;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        SpringBean bean1 = context.getBean(SpringBean.class);
//        bean1.testBean();
//        System.out.println(bean1);
//
//        SpringBean bean2 = context.getBean(SpringBean.class);
//        bean2.testBean();
//        System.out.println(bean2);
//
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//
//        TestBean2 testBean2 = context.getBean(TestBean2.class);
//        System.out.println(testBean2);

//        context.close();
//        TestBean3 testBean3 = context.getBean(TestBean3.class);
//        System.out.println(testBean3);

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("JVM is about to shutdown"); //JVM aka shutdown wena welawe context aka close kirima
//            context.close();
//        }));

//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);

        //request bean from bean id
//        TestBean1 byBeanId = (TestBean1) context.getBean("testBean1"); //first letter aka animware simple wenna ona
//        System.out.println(byBeanId);

        //request bean from bean id and class name
//        TestBean2 testBean2 = context.getBean("testBean2", TestBean2.class);
//        System.out.println(testBean2);

//        TestBean2 testBean2 = context.getBean("Shehan", TestBean2.class);
//        System.out.println(testBean2);

        MyConnection connection = (MyConnection) context.getBean("san");
        System.out.println(connection);

        context.registerShutdownHook();
    }
}