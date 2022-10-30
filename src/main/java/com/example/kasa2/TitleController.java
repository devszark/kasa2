package com.example.kasa2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TitleController {
    @GetMapping("/title")
    public String title(){
        System.out.println("My message from TitleController /title");
        return "title";
    }
}
