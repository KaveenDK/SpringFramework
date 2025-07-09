package lk.ijse.edu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringBeanTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanTwo() {
        System.out.println("SpringBeanTwo - created");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanTwo - setBeanFactory method called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanTwo - setBeanName method called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanTwo - destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanTwo - afterPropertiesSet method called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanTwo - setApplicationContext method called");
    }
}
