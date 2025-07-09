package lk.ijse.edu.di;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI{
    public Test1() {
        System.out.println("Test1 Constructor");
    }


    @Override
    public void sayHello() {
        System.out.println("Hello from Test1");
    }
}
