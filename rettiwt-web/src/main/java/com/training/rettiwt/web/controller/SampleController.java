package com.training.rettiwt.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping
    public Map<String, String> greetings() {
        Map<String, String> response = new HashMap<>();
        response.put("greetings", "hello");
        return response;
    }
}
