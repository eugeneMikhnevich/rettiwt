package com.training.rettiwt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("hello")
    public Map<String, String> greetings() {
        LOGGER.info("hello controller {}", this.getClass().getSimpleName());
        Map<String, String> response = new HashMap<>();
        response.put("greetings", "hello");
        return response;
    }
}
