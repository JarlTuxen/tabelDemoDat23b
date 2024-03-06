package dk.kea.tabeldemodat23b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class butikController {

    @GetMapping("/boghandel")
    public String visVareliste(){
        return "bookstore";
    }

}
