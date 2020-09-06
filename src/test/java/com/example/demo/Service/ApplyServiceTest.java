package com.example.demo.Service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Apply_Info;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.repository.ApplyRepository;
import com.example.demo.service.ApplyService;
import com.example.demo.utils.CompleteApplyInfo;
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
public class ApplyServiceTest extends DemoApplicationTests {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private ApplyService applyService;

//    @Autowired
    @MockBean
    private ApplyRepository applyRepository;

    // should be 5 tests

//    @Test  // 非mock模式
//    public void getAppbyId() {
//        List<CompleteApplyInfo> list = applyService.getAppbyId(100);
//        List<Object> info = applyRepository.getAppbyId(100);
//        List<CompleteApplyInfo> list1 = new ArrayList<CompleteApplyInfo>();
//        for (int i = 0; i < list.size(); i++) {
//            Object[] obj = (Object[]) info.get(i);
//            for (int j = 0; j < obj.length; j++) {
//                if (obj[j] == null) obj[j] = "-1";
//            }
//
//            CompleteApplyInfo currinfo = new CompleteApplyInfo(Integer.parseInt(obj[0].toString()), obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString(), obj[5].toString(), Integer.parseInt(obj[6].toString()), Integer.parseInt(obj[7].toString()), obj[8].toString(), obj[9].toString(), obj[10].toString(), Integer.parseInt(obj[12].toString()), Integer.parseInt(obj[13].toString()));
//            list1.add(currinfo);
//        }
//        assertEquals(list1, list);
//        assertEquals(info.size(), list.size());
//    }
//
//    @Test   // 非mock模式
//    public void getMyApplicants() {
//        List<CompleteResumeInfo> info1 = applyService.getMyApplicants(3);
//        List<Object> info = applyRepository.getMyApplicants(3);
//        List<CompleteResumeInfo> list1 = new ArrayList<CompleteResumeInfo>();
//        System.out.println(info.size());
//        for (int i = 0; i < info.size(); i++) {
//            Object[] obj = (Object[]) info.get(i);
//            for (int j = 0; j < obj.length; j++) {
//                if (obj[j] == null) obj[j] = "-1";
//            }
//            CompleteResumeInfo currInfo = new CompleteResumeInfo(Integer.parseInt(obj[0].toString()), Integer.parseInt(obj[1].toString()), Integer.parseInt(obj[2].toString()), obj[3].toString(), obj[4].toString(), obj[5].toString(), obj[6].toString(), obj[7].toString());
//            list1.add(currInfo);
//        }
//        assertEquals(list1, info1);
//        assertEquals(list1.size(), info1.size());
//    }
//

    @Test
    public void delete_apply_info() {
        applyService.delete_apply_info(99, 96);
        verify(applyRepository, times(1)).delete_apply_info(99, 96);
    }

    @Test
    public void update_apply_info() {
        applyService.update_apply_info(99, 96, 0);
        verify(applyRepository, times(1)).update_apply_info(99, 96, 0);
    }
        @Test
    public void add_apply_info() {

        applyService.add_apply_info(100, 96);
        verify(applyRepository, times(1)).add_apply_info(100, 96);
    }
}
