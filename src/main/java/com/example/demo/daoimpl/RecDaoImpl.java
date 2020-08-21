package com.example.demo.daoimpl;


import com.example.demo.dao.RecDao;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.entity.Resume;
import com.example.demo.repository.RecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecDaoImpl implements RecDao {
    @Autowired
    private RecRepository recRepository;

    public List<Recruit_Info> get_jobs(){
        return recRepository.get_jobs();
    }

    public List<Recruit_Info> filt_jobs(String salary,String cate,String location,String title,String experience,String education){
        String[] splitSalary;
        String[] splitTags;//筛选tag备用
        String lowsalary=null;
        String highsalary=null;
        List<Recruit_Info> tmplist;//筛选tag备用
        if(salary!=null) {
            splitSalary = salary.split("-");
            lowsalary = splitSalary[0];
            highsalary = splitSalary[splitSalary.length - 1];
        }
//        else{
//            lowsalary="0";
//            highsalary="1000000";
//        }
        if(cate == null) cate="";
        if(location == null) location = "";
        if(title == null) title="";
        if(experience == null) experience="";
        if(education == null) education = "";
        if(salary==null){
            System.out.println("456456456456");
            return recRepository.filt_jobs_without_salary(cate,location,title,experience,education);
        }
        else{
            System.out.println("mmmmmmmmm");
            System.out.println(lowsalary);
            System.out.println(highsalary);
            return recRepository.filt_jobs(lowsalary,highsalary,cate,location,title,experience,education);
        }

    }

    public void create_job(Integer userid,String salary,String location,String schedule,String title,String cate,Integer quota,String desc,String exp,String edu){
        recRepository.create_job(userid,salary,location,schedule,title,cate,quota,desc,exp,edu);}

    public List<Recruit_Info> getRecbyId(Integer userid){return recRepository.getRecbyId(userid);}

    public void delete_rec(int rec_id){
        recRepository.deleteByRec_ID(rec_id);
    }


    public void update_rec(int rec_ID, Integer user_ID,  String rec_Salary, String rec_Location, String rec_TimeSchedule,String rec_Title, String rec_Cate, Integer rec_Enrolled, Integer rec_Quota, String rec_Desc, String rec_Experience, String rec_Education){
//         //Recruit_Info r = recRepository.findByRec_ID(rec_ID);
//         /*r.setRec_salary(rec_Salary);
//         r.setRec_Cate(rec_Cate);
//         r.setRec_Desc(rec_Desc);
//         r.setRec_Education(rec_Education);
//         r.setRec_Experience(rec_Experience);
//         r.setRec_Enrolled(rec_Enrolled);
//         r.setRec_Location(rec_Location);
//         r.setRec_Quota(rec_Quota);
//         r.setRec_TimeSchedule(rec_TimeSchedule);
//         r.setRec_Title(rec_Title);

//         recRepository.save(r);*/
        recRepository.update_rec(rec_ID,user_ID,rec_Salary,rec_Location,rec_TimeSchedule,rec_Title,rec_Cate,rec_Enrolled,rec_Quota,rec_Desc,rec_Experience,rec_Education);

    }
}
