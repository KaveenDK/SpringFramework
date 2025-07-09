package lk.ijse.edu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    //the state of the object creation
    public MyConnection() {
        System.out.println("MyConnection Constructor called");
    }

    //there is no method to find state of the property

    //Bean Name aware(Bean ID)
    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection setBeanName method Called");
    }

    //Bean Factory aware(Dependency Injection)
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection setBeanFactory method called");
    }

    //Application Context aware(AOP and DP)
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection setApplicationContext method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection afterPropertiesSet method called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection destroy method called");
    }
}
