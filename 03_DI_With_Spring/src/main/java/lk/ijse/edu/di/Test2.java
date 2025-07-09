package lk.ijse.edu.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DiInterface{
//    @Autowired
//    DI test1;
//
//    public Test2() {
//        System.out.println("Test2 Constructor");
//    }
//
//    public void calledHelloMethod() {
//        test1.sayHello();
//    }

    //constructor through injection
//    DI test1;
//
//    @Autowired
//    public Test2(DI test1) {
//        this.test1 = test1;
//    }
//
//    public void calledHelloMethod() {
//        test1.sayHello();
//    }

    //setter method through injection
//    DI test1;
//
//    @Autowired
//    public void setterMethod(DI test1) {
//        this.test1 = test1;
//    }
//
//    public void calledHelloMethod() {
//        test1.sayHello();
//    }

    //interface through injection
    @Autowired
    DI test1;

    @Override
    public void inject(DI test1) {
        this.test1 = test1;
    }

    public void calledHelloMethod() {
        test1.sayHello();
    }
}
