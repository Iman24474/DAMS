package com.cs5800.dams;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage()
    {
        return "index";
    }
}
