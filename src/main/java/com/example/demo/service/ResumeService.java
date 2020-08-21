package com.example.demo.service;

import com.example.demo.entity.Resume;


import java.util.List;

public interface ResumeService {

    public List<Resume>get_applicants();
    public void alter_resume(int user_id, String name, Boolean gender,String birth,String experience,String education);
    public List<Resume> filt_applicants(String experience,String education);
    public Resume getResumebyId(Integer userid);
}
