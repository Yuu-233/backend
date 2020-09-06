package com.example.demo.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.User;
import com.example.demo.service.ResumeService;
import com.example.demo.serviceimpl.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceTest {
    @Test
    public void contextLoads() {
    }
    @Autowired
    private TokenService tokenService;
    @Test
            public void getTokenTest(){
        User user = new User("testusername","testpassword","testemail",0,"testphone");
        String token = tokenService.getToken(user);
        String t = JWT.create().withAudience(Integer.toString(user.getUser_ID()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        assertEquals(t,token);
        System.out.println(token);
    }
}
