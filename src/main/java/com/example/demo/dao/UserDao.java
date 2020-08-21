package com.example.demo.dao;

import com.example.demo.entity.User;


public interface UserDao {
    User checkUser(String username, String password);
    User findUserByUsername (String username);
    void save (User user);
    User getUserbyId(Integer userid);
    void alter_user_info(Integer userid,String username,String password,String phone,String email,int role);
    void change_state(int userid);
    User getUserbyUsername(String username);
}
