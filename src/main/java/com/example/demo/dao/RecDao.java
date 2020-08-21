package com.example.demo.dao;

import com.example.demo.entity.Recruit_Info;
import java.util.List;


public interface RecDao {
    public List<Recruit_Info> get_jobs();

    public List<Recruit_Info> filt_jobs(String salary,String cate,String location,String title,String experience,String education);

    public void create_job(Integer userid,String salary,String location,String schedule,String title,String cate,Integer quota,String desc,String exp,String edu);
    public List<Recruit_Info> getRecbyId(Integer userid);

    public void delete_rec(int rec_id);
    public void update_rec(int rec_ID, Integer user_ID,  String rec_Salary, String rec_Location, String rec_TimeSchedule,String rec_Title, String rec_Cate, Integer rec_Enrolled, Integer rec_Quota, String rec_Desc, String rec_Experience, String rec_Education);

}
