package com.example.demo.repository;

import com.example.demo.entity.Recruit_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RecRepository extends JpaRepository<Recruit_Info,Integer> {
    @Query(value = "select * from recruit_info",nativeQuery = true)
    List<Recruit_Info> get_jobs();

    @Query(value="select * from recruit_info where" +
            " substring_index(Rec_Salary,'-',1)>=?1 and substring_index(Rec_Salary,'-',-1) <=?2" +
            " and Rec_Cate like CONCAT('%',?3,'%') and Rec_Location like CONCAT('%',?4,'%') and Rec_Title like CONCAT('%',?5,'%')" +
            " and Rec_Experience like CONCAT('%',?6,'%') and Rec_education like CONCAT('%',?7,'%')",nativeQuery = true)
    List<Recruit_Info> filt_jobs(String lowsalary,String highsalary,String cate,String location,String title,String experience,String education);

    @Query(value="select * from recruit_info where" +
            "  Rec_Cate like CONCAT('%',?1,'%') and Rec_Location like CONCAT('%',?2,'%') and Rec_Title like CONCAT('%',?3,'%')" +
            " and Rec_Experience like CONCAT('%',?4,'%') and Rec_education like CONCAT('%',?5,'%')",nativeQuery = true)
    List<Recruit_Info> filt_jobs_without_salary(String cate,String location,String title,String experience,String education);

    @Transactional
    @Modifying
    @Query(value="insert into recruit_info(User_ID,Rec_salary,Rec_Location,Rec_TimeSchedule,Rec_Title,Rec_Cate,Rec_Enrolled,Rec_Quota,Rec_Desc,Rec_Experience,Rec_Education) " +
                                  " values(?1,?2,?3,?4,?5,?6,0,?7,?8,?9,?10)",nativeQuery = true)
    void create_job(Integer userid,String salary,String location,String schedule,String title,String cate,Integer quota,String desc,String exp,String edu);

    @Query(value="select * from Recruit_Info where User_ID = ?",nativeQuery = true)
    List<Recruit_Info> getRecbyId(Integer userid);

    @Transactional
    @Modifying
    @Query(value = "delete from Recruit_Info where Rec_ID=?1",nativeQuery = true)
    public void deleteByRec_ID(@Param("rec_id") int rec_id);

    @Query(value = "select * from Recruit_Info where Rec_ID=?1",nativeQuery = true)
    Recruit_Info findByRec_ID(@Param("rec_id") int rec_id);

    @Transactional
    @Modifying
    @Query(value="update Recruit_Info set User_ID = ?2,Rec_Salary = ?3,Rec_Location = ?4,Rec_TimeSchedule = ?5,Rec_Title = ?6, Rec_Cate = ?7,Rec_Enrolled = ?8,Rec_Quota = ?9,Rec_Desc = ?10,Rec_Experience = ?11,Rec_Education = ?12 where Rec_ID = ?1")
    void update_rec(int rec_ID, Integer user_ID,  String rec_Salary, String rec_Location, String rec_TimeSchedule,String rec_Title, String rec_Cate, Integer rec_Enrolled, Integer rec_Quota, String rec_Desc, String rec_Experience, String rec_Education);

}
