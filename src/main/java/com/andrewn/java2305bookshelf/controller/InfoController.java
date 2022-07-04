package com.andrewn.java2305bookshelf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/info")
    String info(Model model) {
        model.addAttribute("appName", appName);
        return "info";
    }
}
