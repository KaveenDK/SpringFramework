package lk.ijse.edu.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // This annotation indicates that this bean should be given preference when multiple candidates are qualified to autowire.
public class Girl1 implements Agreement {
    public Girl1() {
        System.out.println("Girl1 Constructor");
    }

    public void chat() {
        System.out.println("Chatting with Girl1..");
    }
}
