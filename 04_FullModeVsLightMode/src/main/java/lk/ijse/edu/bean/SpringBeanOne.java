package lk.ijse.edu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringBeanOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanOne() {
        System.out.println("SpringBeanOne - created");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanOne - setBeanFactory method called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanOne - setBeanName method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanOne - destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne - afterPropertiesSet method called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanOne - setApplicationContext method called");
    }
}
