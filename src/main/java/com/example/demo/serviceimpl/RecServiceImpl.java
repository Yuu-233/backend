package com.example.demo.serviceimpl;
import com.example.demo.dao.RecDao;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.service.RecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecServiceImpl implements RecService{

    @Autowired
    RecDao recDao;


    public List<Recruit_Info>get_jobs(){
        return recDao.get_jobs();
    }

    public List<Recruit_Info>filt_jobs(String salary,String cate,String location,String title,String experience,String education){
        List<Recruit_Info> r = recDao.filt_jobs(salary, cate, location, title, experience, education);
        System.out.println(r.size());
        return recDao.filt_jobs(salary,cate,location,title,experience,education);
    }

    public void create_job(Integer userid,String salary,String location,String schedule,String title,String cate,Integer quota,String desc,String exp,String edu){
        recDao.create_job(userid,salary,location,schedule,title,cate,quota,desc,exp,edu);
    }

    public List<Recruit_Info> getRecbyId(Integer userid){
        return recDao.getRecbyId(userid);
    }
    public void delete_rec(int rec_id)
    {
        recDao.delete_rec(rec_id);
    }
    public void update_rec(int rec_ID, Integer user_ID,  String rec_Salary, String rec_Location, String rec_TimeSchedule,String rec_Title, String rec_Cate, Integer rec_Enrolled, Integer rec_Quota, String rec_Desc, String rec_Experience, String rec_Education){
        recDao.update_rec(rec_ID, user_ID,rec_Salary,rec_Location,rec_TimeSchedule,rec_Title,rec_Cate,rec_Enrolled,rec_Quota,rec_Desc, rec_Experience,rec_Education);
    }


}
