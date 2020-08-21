package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "from User where User_Name = :username and Password = :password")
    User checkUser(@Param("username") String username, @Param("password") String password);
    @Query (value="select u from User u WHERE u.User_Name=:username")
    User findUserByUsername(@Param("username") String username);

    @Query(value="select u from User u where u.User_ID=:userid")
    User getUserbyId(@Param("userid")Integer userid);

    @Transactional
    @Modifying
    @Query(value ="update user set User_Name = ?2,Password = ?3,Phone = ?4,Email = ?5,Role = ?6,Encoded=?7 where User_ID = ?1",nativeQuery = true)
    void alter_user_info(Integer userid,String username,String password,String phone,String email,int role,String encoded);

    @Query(value="select * from user where User_Name = ?",nativeQuery = true)
    User getUserbyUsername(String username);

}
