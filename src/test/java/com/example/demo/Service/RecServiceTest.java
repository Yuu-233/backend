package com.example.demo.Service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.repository.RecRepository;
import com.example.demo.service.RecService;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecServiceTest extends DemoApplicationTests {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private RecService recService;

    @MockBean
    private RecRepository recRepository;

    // should be 6 tests
    @Test
    public void get_jobs() {
        List<Recruit_Info> info = new LinkedList<>();
        info.add(new Recruit_Info(1, null, "3000-5000", "上海", null, "test", "test", null, null, null, "不限", "不限"));
        Recruit_Info r = new Recruit_Info();
        r.setUser_ID(2);
        r.setRec_ID(2);
        r.setRec_salary("3000-5000");
        r.setRec_Location("上海");
        r.setRec_TimeSchedule("testtime");
        r.setRec_Title("testtitle");
        r.setRec_Cate("testcate");
        r.setRec_Enrolled(0);
        r.setRec_Quota(2);
        r.setRec_Desc("-");
        r.setRec_Experience("不限");
        r.setRec_Education("不限");
        info.add(r);
//        info.add(new Recruit_Info(2, null, "3000-5000", "北京", null, "test", "test", null, null, null, "不限", "不限"));
        when(recRepository.get_jobs()).thenReturn(info);
        assertEquals(info, recService.get_jobs());
        assertEquals(2, recService.get_jobs().size());

        /*Integer job_count = 1215;
        assertEquals(job_count,recService.get_jobs().size());*/ //非mock
    }

    @Test
    public void filt_jobs_without_salary() {
        List<Recruit_Info> info = new LinkedList<>();
        info.add(new Recruit_Info(1, 5, "8000-10000", "北京", null, "title", null, null, null, null, null, null));
        info.add(new Recruit_Info(2, 10, "9000-10000", "北京", null, "title", null, null, null, null, null, null));
        when(recRepository.filt_jobs_without_salary("", "北京", "", "", "")).thenReturn(info);
        assertEquals(info, recService.filt_jobs(null, null, "北京", null, null, null));
        assertEquals(info.size(), recService.filt_jobs(null, null, "北京", null, null, null).size());
    }

    @Test
    public void filt_jobs_with_salary() {
        List<Recruit_Info> info = new LinkedList<>();
        info.add(new Recruit_Info(1, 5, "8000-10000", "北京", null, "title", null, null, null, null, null, null));
        info.add(new Recruit_Info(2, 10, "9000-10000", "北京", null, "title", null, null, null, null, null, null));
        when(recRepository.filt_jobs("3000", "5000", "", "北京", "", "", "")).thenReturn(info);
        assertEquals(info, recService.filt_jobs("3000-5000", null, "北京", null, null, null));
        assertEquals(info.size(), recService.filt_jobs("3000-5000", null, "北京", null, null, null).size());

    }

    @Test
    public void create_jobs() {
        recService.create_job(100, "8000-10000", "上海闵行", "一周5天", "上海交通大学需要数学老师", "数学老师", 2, "上海交通大学需要数学老师", "5年", "博士");
        verify(recRepository, times(1)).create_job(100, "8000-10000", "上海闵行", "一周5天", "上海交通大学需要数学老师", "数学老师", 2, "上海交通大学需要数学老师", "5年", "博士");
    }

    @Test
    public void getRecbyId() {
        List<Recruit_Info> info = new LinkedList<>();
        info.add(new Recruit_Info(100, "3000-5000", "北京", null, "test", "test", null, null, null, "不限", "不限"));
        when(recRepository.getRecbyId(100)).thenReturn(info);
        assertEquals(info, recService.getRecbyId(100));
        assertEquals(1, recService.getRecbyId(100).size());
    }

    @Test
    public void delete_rec() {
        recService.delete_rec(1);
        verify(recRepository, times(1)).deleteByRec_ID(1);
    }

    @Test
    public void update_rec() {
        Recruit_Info r = new Recruit_Info(1, 2, "3600-4500", " 徐汇 ", "", "公司保洁员/商场保洁员", "保洁", 0, 2, "-", "不限", "不限");
        recService.update_rec(1, 2, "3600-4500", " 徐汇 ", "", "公司保洁员/商场保洁员", "保洁", 0, 2, "-", "不限", "不限");

        assertEquals(1, r.getRec_ID());
        assertEquals(2, r.getUser_ID());
        assertEquals("3600-4500", r.getRec_salary());
        assertEquals(" 徐汇 ", r.getRec_Location());
        assertEquals("", r.getRec_TimeSchedule());
        assertEquals("公司保洁员/商场保洁员", r.getRec_Title());
        assertEquals("保洁", r.getRec_Cate());
        assertEquals(0, r.getRec_Enrolled());
        assertEquals(2, r.getRec_Quota());
        assertEquals("-", r.getRec_Desc());
        assertEquals("不限", r.getRec_Education());
        assertEquals("不限", r.getRec_Experience());
        verify(recRepository, times(1)).update_rec(1, 2, "3600-4500", " 徐汇 ", "", "公司保洁员/商场保洁员", "保洁", 0, 2, "-", "不限", "不限");
    }
}
