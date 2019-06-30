package com.nickolasfisher.slow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlowApplication.class, args);
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(2000);
        return "{\"hello\":\"hello\"}";
    }
}
