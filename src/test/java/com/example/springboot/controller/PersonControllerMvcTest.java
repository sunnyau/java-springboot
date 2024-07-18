package com.example.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    // @InjectMocks
    // private PersonController controller;

    // @BeforeEach
    // public void setUp() {
    // mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    // }

    @Test
    public void testGetMethod() throws Exception {
        String expectedContent = """
                [{"id":1,"name":"Edward","title":"Racing Driver"},\
                {"id":1001,"name":"Andy","title":"Tennis player"},\
                {"id":1002,"name":"Bart","title":"Footballer"},\
                {"id":1003,"name":"Carl","title":"Basketball player"},\
                {"id":1004,"name":"Dennis","title":"Swimmer"}]""";
        mockMvc.perform(get("/person/all"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedContent));
    }

    @Test
    public void testPostMethod() throws Exception {
        String content = """
                {"name":"Edward","title":"Racing Driver"}""";
        String expectedContent = """
                {"id":1,"name":"Edward","title":"Racing Driver"}""";
        mockMvc.perform(post("/person/json").contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedContent));
    }
}