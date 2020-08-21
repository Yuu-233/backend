package com.example.demo.serviceimpl;
import com.example.demo.dao.ResumeDao;
import com.example.demo.entity.Resume;
import com.example.demo.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    ResumeDao resumeDao;

    public List<Resume> get_applicants(){
        return resumeDao.get_applicants();
    }
    public void alter_resume(int user_id, String name, Boolean gender,String birth,String experience,String education){
        resumeDao.alter_resume(user_id,name,gender,birth,experience,education);
    }
    public List<Resume> filt_applicants(String experience,String education){
        return resumeDao.filt_applicants(experience,education);
    }
    public Resume getResumebyId(Integer userid){
        return resumeDao.getResumebyId(userid);
    }

}
