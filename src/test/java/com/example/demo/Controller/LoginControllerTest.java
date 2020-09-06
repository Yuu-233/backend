package com.example.demo.Controller;

import com.example.demo.DemoApplicationTests;
import com.example.demo.controller.UserController;

import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest extends DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    private MockMvc mockMvc;//模拟网络请求

    @Autowired
    private WebApplicationContext context;


    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void login_admin() throws Exception {
        MvcResult result = mockMvc.perform(get("/login?username=Tiffani Anstice&password=2152fyrx").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(2)).andReturn();
    }
    @Test
    public void login_disabled_user() throws Exception {
        MvcResult result = mockMvc.perform(get("/login?username=Phyllys Beadnell&password=3819ooij").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(3)).andReturn();
    }
    @Test
    public void login_common_user() throws Exception {
        MvcResult result = mockMvc.perform(get("/login?username=Concettina Mingus&password=0481ndux").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(1)).andReturn();
    }
    @Test
    public void login_wrong() throws Exception {
        MvcResult result = mockMvc.perform(get("/login?username=Concettina Mingus&password=0481n789").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(0)).andReturn();
    }
    @Test
    public void register_success() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/register?username=Aurora Green&password=7852369&email=24277898967@177.com&phone=15996318788").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(1)).andReturn();
    }
    @Test
    public void register_unsuccess() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/register?username=Concettina Mingus&password=0481ndux&email=24277898967@177.com&phone=15996318788").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.status").value(0)).andReturn();
    }

}
