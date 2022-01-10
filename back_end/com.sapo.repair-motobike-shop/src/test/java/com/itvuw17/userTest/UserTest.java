package com.itvuw17.userTest;

import com.sapo.StartWebApplication;
import com.sapo.entities.User;
import com.sapo.repositories.UserRepository;
import com.sapo.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Optional;



@SpringBootTest
public class UserTest {
    ApplicationContext applicationContext = SpringApplication.run(StartWebApplication.class);
    UserRepository userRepository = applicationContext.getBean(UserRepository.class);

    //Test tạo user
    @Test
    @Order(1)
    public void testSignUp() throws Exception{
        User user =  new User();
        user.setCode("NV000018");
        user.setAddress("Hà nội");
        user.setName("Nguyễn Văn Định");
        user.setEmail("nguyenvandinh@gmail.com");
        user.setPassword("123456a@");
        user.setPhone("0972665176");
        user.setSex(true);
        user.setUsername("nguyendinh123");
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
    //Test tìm user theo id
    @Test
    @Order(2)
    public void getUserTest(){
        User user = userRepository.findById(1).get();
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }
    //Test tìm list user
    @Test
    @Order(3)
    public void getListUserTest(){
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    //Test tìm user bằng username tồn tại
    @Test
    @Order(4)
    public void testFindUserByUsernameExit(){
        String username = "nguyendinh123";
        Optional<User> user = userRepository.findByUsername(username);
        Assertions.assertThat(user.get().getUsername()).isEqualTo(username);
    }

    //Test tìm user



}
