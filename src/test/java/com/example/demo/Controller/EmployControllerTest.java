package com.example.demo.Controller;


import com.example.demo.DemoApplicationTests;
import com.example.demo.service.ApplyService;
import com.example.demo.service.EmployService;
import com.example.demo.utils.CompleteApplyInfo;
import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployControllerTest extends DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    private MockMvc mockMvc;//模拟网络请求
    @MockBean
//    @Autowired
    private EmployService employService;
    @Autowired
    private WebApplicationContext context;


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

    //should be 5 tests
    @Test
    public void add_employ_info() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/add_employ_info?user_id=100&rec_id=125")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        verify(employService, times(1)).add_employ_info(100, 125);
    }

    @Test
    public void delete_employ_info() throws Exception {
        MvcResult result2 = mockMvc.perform(get("/delete_employ_info?user_id=99&rec_id=96")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        verify(employService, times(1)).delete_employ_info(99, 96);
    }

    @Test
    public void update_employ_info() throws Exception {
        MvcResult result3 = mockMvc.perform(get("/update_employ_info?user_id=99&rec_id=223&accepted=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        verify(employService, times(1)).update_employ_info(99, 223, 1);
    }

    @Test
    public void getEmpbyId() throws Exception {
        MvcResult result = mockMvc.perform(get("/getEmpbyId?userid=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<CompleteEmployInfo> app = om.readValue(resultContent, new TypeReference<List<CompleteEmployInfo>>() {
        });
        assertEquals(employService.getEmpbyId(1), app);
    }

    @Test
    public void getMyEmployees() throws Exception {
        MvcResult result = mockMvc.perform(get("/getMyEmployees?rec_id=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<CompleteResumeInfo> res = om.readValue(resultContent, new TypeReference<List<CompleteResumeInfo>>() {
        });
        assertEquals(employService.getMyEmployees(1), res);
    }
}
