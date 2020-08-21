package com.example.demo.repository;

import com.example.demo.entity.CompositePK.Employ_InfoPK;
import com.example.demo.entity.Employ_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployRepository extends JpaRepository<Employ_Info, Employ_InfoPK> {


    @Query(value="select * from employ_info where User_ID = ?1 and Rec_ID = ?2",nativeQuery = true)
    Employ_Info checkHistory(Integer user_id, Integer rec_id);

    @Transactional
    @Modifying
    @Query(value="insert into employ_info(User_ID,Rec_ID,Accepted) values(?1,?2,0)",nativeQuery = true)
    public void add_employ_info(Integer user_id,Integer rec_id);

    @Transactional
    @Modifying
    @Query(value="delete from employ_info where User_ID=?1 and Rec_ID=?2", nativeQuery = true)
    public void delete_employ_info(Integer user_id,Integer rec_id);

    @Transactional
    @Modifying
    @Query(value="update employ_info  set Accepted=?3 where User_ID =?1 and Rec_ID =?2", nativeQuery = true )
    public void update_employ_info(Integer user_id,Integer rec_id,Integer accepted);

    @Query(value = " select * \n" +
            "from employ_info natural join resume where \n" +
            "Rec_ID =?",nativeQuery = true)
    List<Object> getMyEmployees(Integer rec_id);

    @Query(value= "select *\n" +
            "from\n" +
            "(select Rec_ID ,Rec_Salary,Rec_Location,Rec_TimeSchedule,Rec_Title,Rec_Cate,Rec_Enrolled,Rec_Quota,Rec_Desc,Rec_Experience,Rec_Education,Tags from recruit_info where recruit_info.Rec_ID in (select employ_info.Rec_ID from employ_info where employ_info.User_ID = ?1)) as R\n" +
            "natural join employ_info",nativeQuery = true)
    public List<Object> getEmpbyId(Integer userid);
}
