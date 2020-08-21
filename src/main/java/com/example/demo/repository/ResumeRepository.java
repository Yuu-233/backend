package com.example.demo.repository;

import com.example.demo.entity.Apply_Info;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {
    @Query(value="select r from Resume r")
    List<Resume> get_applicants();

    @Query(value="select User_ID from Resume where User_ID = :user_id")
    int checkUserbyId(int user_id);

    @Transactional
    @Modifying
    @Query(value="insert into Resume(User_ID,Name,Gender,Birth,Experience,Education) values(?,?,?,?,?,?)",nativeQuery = true)
    void add_resume(Integer user_id, String name, Boolean gender,String birth,String experience,String education);

    @Transactional
    @Modifying
    @Query(value="update Resume set Name=?2,Gender=?3,Birth=?4,Experience=?5,Education=?6 where User_ID=?1",nativeQuery = true)
    void alter_resume(Integer user_id, String name, Boolean gender,String birth,String experience,String education);

    @Query(value="select * from Resume where Experience like CONCAT('%',?1,'%') and Education like CONCAT('%',?2,'%')",nativeQuery = true)
    List<Resume> filt_applicants(String experience,String education);

    @Query(value="select * from Resume where User_ID = ?",nativeQuery = true)
    Resume getResumebyId(int userid);
}
