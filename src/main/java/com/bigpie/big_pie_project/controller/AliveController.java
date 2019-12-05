package com.bigpie.big_pie_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController {
    @GetMapping("/alive")
    public String checkServer(){
        return "I'm alive!";
    }
}
