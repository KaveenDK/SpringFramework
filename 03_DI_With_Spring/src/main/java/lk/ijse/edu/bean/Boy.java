package lk.ijse.edu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    //Property injection
//    Girl girl = new Girl();
//
//    public void chatWithGirl() {
//        girl.chat();
//    }

    //Constructor through dependency injection
//    Girl girl;
//
//    public Boy(Girl girl) {
//        this.girl = girl;
//    }
//
//    public void chatWithGirl() {
//        Boy boy = new Boy(new Girl());
//        boy.chat();
//    }

    //Setter method through dependency injection
//    Girl girl;
//
//    public void setterMethod(Girl girl) {
//        this.girl = girl;
//    }
//
//    public void chatWithGirl() {
//        Boy boy = new Boy();
//        boy.setterMethod(new Girl());
//        boy.girl.chat();
//    }
    @Autowired
    @Qualifier("girl2") // Use @Qualifier to specify which implementation to inject when multiple candidates are available
    Agreement girl;

    public Boy() {
        System.out.println("Boy Constructor");
    }

    public void chatWithGirl() {
        girl.chat();
    }
}
