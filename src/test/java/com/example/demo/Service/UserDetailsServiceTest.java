package com.example.demo.Service;


import com.example.demo.entity.User;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserDetailsService userDetailsService;

//    @Test
//    public void loadUserByUsername() {
//        User user = new User(1, "Tiffani Anstice", "2152fyrx", "5897311806@564.com", 1, "07401238030");
//        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_admin"));
//        UserDetails u1 = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getEncoded(),grantedAuthorities);
//        UserDetails user1 = userDetailsService.loadUserByUsername("Tiffani Anstice");
//        assertEquals( u1, user1);
//    }
}

