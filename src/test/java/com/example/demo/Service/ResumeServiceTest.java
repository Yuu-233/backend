package com.example.demo.Service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.entity.Resume;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.service.ResumeService;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResumeServiceTest extends DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ResumeService resumeService;

    @MockBean
    private ResumeRepository resumeRepository;

//     should be 4 tests
    @Test
    public void get_applicants() {
        List<Resume> resumes = new LinkedList<>();
        resumes.add(new Resume("test1", false, "1995-01-29", "无", "本科"));
        resumes.add(new Resume( "test2", true, "1967-10-18", "3年", "硕士"));
        when(resumeRepository.get_applicants()).thenReturn(resumes);

        assertEquals(resumes, resumeService.get_applicants());
        assertEquals(2, resumeService.get_applicants().size());
        /*Integer resume_count = 801;
        assertEquals(resume_count,resumeService.get_applicants().size());*/
    }

    @Test
    public void filt_applicants() {
        List<Resume> resumes = new LinkedList<>();
        resumes.add(new Resume(1, "test1", false, "1995-01-29", "无", "本科"));
        when(resumeRepository.filt_applicants("", "本科")).thenReturn(resumes);
        assertEquals(resumes, resumeService.filt_applicants(null, "本科"));
        assertEquals(1, resumeService.filt_applicants(null, "本科").size());

        /*Integer filt_count = 13;
        assertEquals(filt_count,resumeService.filt_applicants("1年","高中").size());*/
    }

    @Test
    public void getResumebyId() {
        Resume r = new Resume(1001, "Anna Bryan", true, "1995-05-05", "2年", "研究生");
        when(resumeRepository.getResumebyId(1001)).thenReturn(r);
        assertEquals(r, resumeService.getResumebyId(1001));
    }

    @Test
    public void alter_resume_exist_user() {
        Resume res = new Resume(1, "Noah Neno", false, "1929-02-10", "13年", "初中");
        when(resumeRepository.getResumebyId(1)).thenReturn(res);
        resumeService.alter_resume(1, "Noah Neno", false, "1929-02-10", "15年", "本科");
//        assertEquals("15年", resumeRepository.getResumebyId(1).getExperience());
        verify(resumeRepository, times(1)).getResumebyId(1);
        verify(resumeRepository, times(1)).alter_resume(1, "Noah Neno", false, "1929-02-10", "15年", "本科");
    }

    @Test
    public void alter_resume_not_exist_user() {
        resumeService.alter_resume(801, "Hannah Jackson", false, "1980-02-10", "15年", "本科");
        verify(resumeRepository, times(1)).getResumebyId(801);
        verify(resumeRepository, times(1)).add_resume(801, "Hannah Jackson", false, "1980-02-10", "15年", "本科");
    }
}
