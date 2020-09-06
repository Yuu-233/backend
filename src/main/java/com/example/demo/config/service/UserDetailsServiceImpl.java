package com.example.demo.config.service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserbyUsername(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user!=null) {
            if (user.getRole() == 1)
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_admin"));
            if(user.getRole() == 0)
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_user"));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getEncoded(),grantedAuthorities);
    }
}
