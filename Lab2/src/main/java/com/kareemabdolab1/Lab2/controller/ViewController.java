package com.kareemabdolab1.Lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "buddiesList"; // Assuming you have a file named buddiesList.html
    }
}
