package com.training.rettiwt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String index() {
        logger.warn("test warn log {}", this.getClass().getSimpleName());
        logger.debug("test debug log {}", this.getClass().getSimpleName());
        return "index.html";
    }

    @GetMapping("error")
    public String error() {
        try {
            throw new IllegalStateException("Custom exeption");
        } catch (IllegalStateException e) {
            logger.error("ERROR {}", this.getClass().getSimpleName(), e);
        }
        return "index.html";
    }
}
