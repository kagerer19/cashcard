package com.example.cashcard.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

    @Value("${}")
    private String key;

    @GetMapping("")
    public String home(){
        return key;
    }
}
