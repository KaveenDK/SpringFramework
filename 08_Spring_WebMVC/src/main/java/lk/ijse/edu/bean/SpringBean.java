package lk.ijse.edu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    public SpringBean() {
        System.out.println("SpringBean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBean setBeanFactory method called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBean setBeanName method called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBean afterPropertiesSet method called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBean setApplicationContext method called");
    }
}
