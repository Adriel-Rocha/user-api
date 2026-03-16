package com.adriel.user_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage() {
        return "Spring boot is Working!";
    }

}
