package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.serviceimpl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    TokenService tokenService;

    @CrossOrigin
    @RequestMapping("/getUserbyId")
    public User getUserbyId(@RequestParam("userid") Integer userid){
        return userService.getUserbyId(userid);
    }

    @CrossOrigin
    @RequestMapping("/alter_user_info")
    public void alter_user_info(@RequestParam("userid") Integer userid,@RequestParam("username")String username,@RequestParam("password") String password,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("role") int role){
        userService.alter_user_info(userid,username,password,phone,email,role);
    }

    //Admin function
    @CrossOrigin
    @RequestMapping("/change_state")
    public void change_state(@RequestParam("userid")int userid){
        userService.change_state(userid);
    }

    @CrossOrigin
    @RequestMapping("/getUserbyUsername")
    public User getUserbyUsername(@RequestParam("username")String username){
        return userService.getUserbyUsername(username);
    }

//
//    @RequestMapping("/mylogin")
//    public Object login( @RequestParam("username") String username,
//                         @RequestParam("password") String password){
//        JSONObject jsonObject=new JSONObject();
//        User userForBase=userService.getUserbyUsername(username);
//        if(userForBase==null){
//            jsonObject.put("message","登录失败,用户不存在");
//            return jsonObject;
//        }else {
//            if (!userForBase.getPassword().equals(password)){
//                jsonObject.put("message","登录失败,密码错误");
//                return jsonObject;
//            }else {
//                String token = tokenService.getToken(userForBase);
//                jsonObject.put("token", token);
//                jsonObject.put("user", userForBase);
//                return jsonObject;
//            }
//        }
//    }
//
//    @UserLoginToken
//    @RequestMapping("/mygetMessage")
//    public String getMessage(){
//        System.out.println(23333);
//        return "你已通过验证";
//    }
}
