package com.example.demo.daoimpl;

import com.example.demo.dao.ResumeDao;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResumeDaolmpl implements ResumeDao {
     @Autowired
     private ResumeRepository resumeRepository;

     @Override
     public List<Resume>get_applicants(){
          return resumeRepository.get_applicants();
     }

     @Override
     public void alter_resume(int user_id,String name,Boolean gender,String birth,String experience,String education){
           Resume exist_user= resumeRepository.getResumebyId(user_id);
           System.out.println(exist_user);
           if(exist_user != null)
               resumeRepository.alter_resume(user_id,name,gender,birth,experience,education);
           else
               resumeRepository.add_resume(user_id,name,gender,birth,experience,education);


     }

     @Override
     public List<Resume> filt_applicants(String experience,String education){
         /*String[] splitSalary;
         String[] splitTags;
         String lowsalary=null;
         String highsalary=null;
         if(salary!=null) {
             splitSalary = salary.split("-");
             lowsalary = splitSalary[0];
             highsalary = splitSalary[splitSalary.length - 1];
         }*/  //Resume中未设置期望薪酬
         if(experience==null || experience.equals("不限")) experience="";
         if(education==null || education.equals("不限"))  education="";
         return resumeRepository.filt_applicants(experience,education);
     }

     public Resume getResumebyId(Integer userid){
         return resumeRepository.getResumebyId(userid);
     }
}
