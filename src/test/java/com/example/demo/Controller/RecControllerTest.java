package com.example.demo.Controller;

import com.example.demo.DemoApplicationTests;

import com.example.demo.entity.Recruit_Info;
import com.example.demo.entity.Resume;
import com.example.demo.repository.RecRepository;
import com.example.demo.service.RecService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
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

public class RecControllerTest extends DemoApplicationTests {
    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc;//模拟网络请求

    @Autowired
    private WebApplicationContext context;

//    @Autowired
    @MockBean
    private RecService recService;

    @MockBean
    private RecRepository recRepository;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void get_jobs() throws Exception {
        MvcResult result = mockMvc.perform(get("/get_jobs").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Resume> resumes = om.readValue(resultContent, new TypeReference<List<Resume>>() {
        });
        assertEquals(recService.get_jobs().size(), resumes.size());
    }

    @Test
    public void filt_jobs() throws Exception {
        MvcResult result = mockMvc.perform(get("/filt_jobs?salary=6000-7000&location=徐汇").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Recruit_Info> rec = om.readValue(resultContent, new TypeReference<List<Recruit_Info>>() {
        });
        assertEquals(recService.filt_jobs("6000-7000", "徐汇", null, null, null, null), rec);
    }

    @Test
    public void getRecbyId() throws Exception {
        MvcResult result = mockMvc.perform(get("/getRecbyId?userid=2").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Recruit_Info> rec = om.readValue(resultContent, new TypeReference<List<Recruit_Info>>() {
        });
        assertEquals(recService.getRecbyId(2), rec);

    }


    @Test
    public void update_rec() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/update_rec?rec_ID=3&user_ID=82&rec_Salary=4500-8000&rec_Location=松江&rec_TimeSchedule=-&rec_Title=服务员包吃住4500起&rec_Cate=服务员&rec_Enrolled=4&rec_Quota=5&rec_Desc=-&rec_Experience=不限&rec_Education=不限")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        verify(recService, times(1)).update_rec(3, 82, "4500-8000", "松江", "-", "服务员包吃住4500起", "服务员", 4, 5, "-", "不限", "不限");
    }

    @Test
    public void delete_job() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/delete_rec?rec_id=499")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        verify(recService, times(1)).delete_rec(499);
    }

    @Test
    public void create_job() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/create_job?userid=1000&salary=4000-9000&location=上海，闵行&schedule=一周5天&title=网络客服&cate=网络/在线客服&quota=5&desc=网络/在线客服&exp=不限&edu=本科")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        verify(recService, times(1)).create_job(1000, "4000-9000", "上海，闵行", "一周5天", "网络客服", "网络/在线客服", 5, "网络/在线客服", "不限", "本科");
    }

}
