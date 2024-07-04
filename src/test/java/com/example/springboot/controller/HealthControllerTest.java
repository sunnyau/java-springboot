package com.example.springboot.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthControllerTest {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getHealth() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/health", String.class);
        // assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}

// @SpringBootTest
// @AutoConfigureMockMvc
// public class HealthControllerTest {

//     private static String OPEN_API_DEFINITION = "./openapi.yml";

//     @InjectMocks
//     private HealthController healthController;
//     private MockMvc mockMvc;

//     @Before
//     public void setUp() {
//         mockMvc = MockMvcBuilders.standaloneSetup(healthController).build();
//     }

//     @Test
//     public void shouldReturnHealth() throws Exception {
//         mockMvc.perform(get("/health"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().string("healthy"));
//                 //.andExpect(openApi().isValid(OPEN_API_DEFINITION));
//     }
// }