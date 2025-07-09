package lk.ijse.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {
    public ItemController() {
        System.out.println("Item Constructor");
    }

    @GetMapping()
    public String item() {
        return "item";
    }
}
