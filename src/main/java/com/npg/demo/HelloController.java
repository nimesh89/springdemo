package com.npg.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nimesh on 1/31/16.
 */
@Controller
public class HelloController {

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!ssss");
        return "helloWorld";
    }
}
