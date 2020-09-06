package com.example.demo.Service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest extends DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    // should be 6 tests
    @Test
    public void getUserById() {
        /*Integer userId=1234;
        User user = new User("testusername","testpassword","testemail",false,"testphone");
        when(userRepository.getUserbyId(userId)).thenReturn(user);
        assertEquals(user,userService.getUserbyId(userId));*/ //mock模式

        //User user= new User(1, "Tiffani Anstice", "2152fyrx", "5897311806@564.com",  true,"07401238030");
        //assertEquals(user,userService.getUserbyId(1));//非mock模式
        //assertEquals(user,userService.getUserbyId(userId)); *///mock模式

        User user = new User(1, "Tiffani Anstice", "2152fyrx", "5897311806@564.com", 1, "07401238030");
        when(userRepository.getUserbyId(1)).thenReturn(user);
        assertEquals(user, userService.getUserbyId(1));//非mock模式*/
    }

    @Test
    public void checkUser() {
        User user = new User();
        user.setUser_ID(1);
        user.setUserName("Tiffani Anstice");
        user.setPassword("2152fyrx");
        user.setEmail("5897311806@564.com");
        user.setRole(1);
        user.setPhone("07401238030");
        when(userRepository.checkUser("Tiffani Anstice", "2152fyrx")).thenReturn(user);
        assertEquals(user, userService.checkUser("Tiffani Anstice", "2152fyrx"));
    }

    @Test
    public void getUserByUsername() {
        String name = "Tiffani Anstice";
//      User u = new User(1002, "Jack Tarantino", "456sdfsd", "9690489496@027.com", 1, "18544775620");
        User user = new User(1, "Tiffani Anstice", "2152fyrx", "5897311806@564.com", 1, "07401238030");
        when(userRepository.getUserbyUsername(name)).thenReturn(user);
        assertEquals(user, userService.getUserbyUsername(name));
    }

    @Test
    public void alter_user_info() {
        userService.alter_user_info(1, "Tiffani Anstice", "2152fyrx", "07041238030", "5897311806@564.com", 2);
//        when(passwordEncoder.encode("2152fyrx")).thenReturn("qqqq");
        //userRepository的参数多了一个encoded,即加密后的密码
        verify(userRepository, times(1)).findUserByUsername("Tiffani Anstice");
//        verify(userRepository, times(1)).alter_user_info(1, "Tiffani Anstice", "2152fyrx", "07041238030", "5897311806@564.com", 2, passwordEncoder.encode("2152fyrx"));
    }

    @Test
    public void change_state_0() {
        User user = new User(2, "Aurora Carding", "9031ufxb", "4495771966@598.com", 2, "92114684077");
        when(userRepository.getUserbyId(1)).thenReturn(user);
        userService.change_state(1);
        assertEquals(0, user.getRole());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void change_state_2() {
        User user = new User(2, "Aurora Carding", "9031ufxb", "4495771966@598.com", 0, "92114684077");
        when(userRepository.getUserbyId(1)).thenReturn(user);
        userService.change_state(1);
        assertEquals(2, user.getRole());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void register() {
        Boolean b = userService.register("Jack Brown", "7892lkjh", "78945625@258.com", "Shaghai");
        assertEquals(true, b);
        verify(userRepository, times(1)).findUserByUsername("Jack Brown");
    }
}
