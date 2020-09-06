package com.example.demo.Service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Apply_Info;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.repository.ApplyRepository;
import com.example.demo.repository.EmployRepository;
import com.example.demo.service.EmployService;
import com.example.demo.utils.CompleteApplyInfo;
import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployServiceTest extends DemoApplicationTests {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private EmployService employService;

    @Autowired
//    @MockBean
    private EmployRepository employRepository;

    // should be 5 tests
//    @Test
//    public void add_employ_info() {
//
//        employService.add_employ_info(100, 96);
//        verify(employRepository, times(1)).add_employ_info(100, 96);
//    }
//    @Test
//    public void delete_employ_info() {
//        employService.delete_employ_info(99, 96);
//        verify(employRepository, times(1)).delete_employ_info(99, 96);
//    }
//
//    @Test
//    public void update_employ_info() {
//        employService.update_employ_info(99, 96, 0);
//        verify(employRepository, times(1)).update_employ_info(99, 96, 0);
//    }
    @Test // 非mock模式
    public void getEmpbyId() {
        List<CompleteEmployInfo> list = employService.getEmpbyId(1);
        List<Object> info = employRepository.getEmpbyId(1);
        List<CompleteEmployInfo> list1 = new ArrayList<CompleteEmployInfo>();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) info.get(i);
            for (int j = 0; j < obj.length; j++) {
                if (obj[j] == null) obj[j] = "-1";
            }

            CompleteEmployInfo currinfo = new CompleteEmployInfo(Integer.parseInt(obj[0].toString()), obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString(), obj[5].toString(), Integer.parseInt(obj[6].toString()), Integer.parseInt(obj[7].toString()), obj[8].toString(), obj[9].toString(), obj[10].toString(), Integer.parseInt(obj[12].toString()), Integer.parseInt(obj[13].toString()));
            list1.add(currinfo);
        }
        assertEquals(list1, list);
        assertEquals(info.size(), list.size());
    }

    @Test   // 非mock模式
    public void getMyEmployees() {
        List<CompleteResumeInfo> info1 = employService.getMyEmployees(3);
        List<Object> info = employRepository.getMyEmployees(3);
        List<CompleteResumeInfo> list1 = new ArrayList<CompleteResumeInfo>();
        System.out.println(info.size());
        for (int i = 0; i < info.size(); i++) {
            Object[] obj = (Object[]) info.get(i);
            for (int j = 0; j < obj.length; j++) {
                if (obj[j] == null) obj[j] = "-1";
            }
            CompleteResumeInfo currInfo = new CompleteResumeInfo(Integer.parseInt(obj[0].toString()), Integer.parseInt(obj[1].toString()), Integer.parseInt(obj[2].toString()), obj[3].toString(), obj[4].toString(), obj[5].toString(), obj[6].toString(), obj[7].toString());
            list1.add(currInfo);
        }
        assertEquals(list1, info1);
        assertEquals(list1.size(), info1.size());
    }


}
