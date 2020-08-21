package com.example.demo.Controller;

import com.example.demo.DemoApplicationTests;
import com.example.demo.controller.UserController;
import com.example.demo.entity.Resume;

import com.example.demo.service.ResumeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ResumeControllerTest extends DemoApplicationTests {


    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc;//模拟网络请求

    @Autowired
    private WebApplicationContext context;

    @Autowired
//    @MockBean
    private ResumeService resumeService;

    @Autowired
    private UserController userController;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {

//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void get_applicants() throws Exception {
        MvcResult result = mockMvc.perform(get("/get_applicants").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Resume> resumes = om.readValue(resultContent, new TypeReference<List<Resume>>() {
        });
        assertEquals(resumeService.get_applicants().size(), resumes.size());
    }


    @Test
    public void filt_applicants() throws Exception {
        String exp = "8年";
        String edu = "博士";
        MvcResult result = mockMvc.perform(get("/filt_applicants?experience=8年&education=博士")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Resume> resumes = om.readValue(resultContent, new TypeReference<List<Resume>>() {
        });
        assertEquals(resumeService.filt_applicants(exp, edu), resumes);
    }

    @Test
    public void getResumebyId() throws Exception {
        MvcResult result = mockMvc.perform(get("/getResumebyId?userid=5"))
                .andExpect(status().isOk()).andReturn();
        Resume u = new Resume(5, "Chan Shah", false, "1969-07-14", "13年", "研究生");
        String resultContent = result.getResponse().getContentAsString();
        Resume res = om.readValue(resultContent, new TypeReference<Resume>() {
        });
        assertEquals(u, res);
    }
//    @Test
//    public void alter_resume() throws Exception{
//        MvcResult result = mockMvc.perform(get("/alter_resume?user_id=1&name=Noah Neno&gender=false&birth=1929-02-10&experience=15年&education=初中")
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk())
//                .andReturn();
//        verify(resumeService, times(1)).alter_resume(1,"Noah Neno", false, "1929-02-10", "15年", "初中");
//    }//mock模式
}
