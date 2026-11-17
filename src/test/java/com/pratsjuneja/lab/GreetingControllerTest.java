package com.pratsjuneja.lab;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void greetsByName() {
        assertThat(GreetingController.greet("Pratyush")).isEqualTo("Hello, Pratyush!");
    }

    @Test
    void blankNameFallsBackToDefault() {
        assertThat(GreetingController.greet("  ")).isEqualTo("Hello, Harness!");
    }

    @Test
    void rootEndpointReturnsGreeting() throws Exception {
        mvc.perform(get("/").param("name", "SE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, SE!"))
                .andExpect(jsonPath("$.version").exists());
    }

    @Test
    void healthEndpointIsUp() throws Exception {
        mvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
