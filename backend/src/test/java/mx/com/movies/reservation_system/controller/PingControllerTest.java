package mx.com.movies.reservation_system.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(PingController.class)
public class PingControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getPing_returns200WithContent() throws Exception {
        String output = "Hello, World!";

        mockMvc.perform(get("/api/ping"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(output));
    }
}
