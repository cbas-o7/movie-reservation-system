package mx.com.movies.reservation_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    private static final String CONTENT = "Hello, World!";

    @GetMapping("/api/ping")
    public Ping ping() {
        return new Ping(CONTENT);
    }

}
