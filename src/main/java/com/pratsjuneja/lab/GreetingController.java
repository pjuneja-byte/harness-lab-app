package com.pratsjuneja.lab;

import java.net.InetAddress;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // APP_VERSION is set per deployment so you can see which version (canary vs. stable) answered.
    @Value("${APP_VERSION:dev}")
    private String version;

    @GetMapping("/")
    public Map<String, String> hello(@RequestParam(defaultValue = "Harness") String name) throws Exception {
        return Map.of(
                "message", greet(name),
                "version", version,
                "pod", InetAddress.getLocalHost().getHostName());
    }

    static String greet(String name) {
        if (name == null || name.isBlank()) {
            name = "Harness";
        }
        return "Hello, " + name.trim() + "!";
    }
}
