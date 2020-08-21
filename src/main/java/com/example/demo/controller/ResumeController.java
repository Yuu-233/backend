package com.example.demo.controller;

import com.example.demo.entity.Resume;
import com.example.demo.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @CrossOrigin
    @RequestMapping("/get_applicants")
    public List<Resume> get_applicants(){
        return resumeService.get_applicants();
    }

    @CrossOrigin
    @RequestMapping("/alter_resume")
    public void alter_resume(@RequestParam("user_id") int user_id, @RequestParam("name")String name, @RequestParam("gender")Boolean gender,@RequestParam("birth")String birth,@RequestParam("experience")String experience,@RequestParam("education")String education){
      resumeService.alter_resume(user_id,name,gender,birth,experience,education);
    }

    @CrossOrigin
    @RequestMapping("/filt_applicants")
    public List<Resume> filt_applicants(
                         @RequestParam(value="experience",required = false)String experience,
                         @RequestParam(value="education",required = false)String education){
        return resumeService.filt_applicants(experience,education);
    }

    @CrossOrigin
    @RequestMapping("/getResumebyId")
    public Resume getResumebyId(@RequestParam("userid")Integer userid){
        return resumeService.getResumebyId(userid);
    }
}
