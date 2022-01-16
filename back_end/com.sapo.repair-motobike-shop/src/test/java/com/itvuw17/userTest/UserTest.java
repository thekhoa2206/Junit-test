package com.itvuw17.userTest;

import com.sapo.StartWebApplication;
import com.sapo.controllers.admin.AdminUserController;
import com.sapo.dto.users.UserDTORequest;
import com.sapo.exception.InputException;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import javax.security.auth.login.LoginException;
import java.io.IOException;



//Các test case tạo user
@SpringBootTest
@DirtiesContext
public class UserTest {
    static ApplicationContext applicationContext = SpringApplication.run(StartWebApplication.class);
// test username và password
    //Test tạo user thành công
    @Test
    public void testSignUpSuccess() throws IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("admin1234");
        user.setPassword("admin");
        user.setPhone("0987278561");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }

    //Test tạo user khi username bị trùng
    @Test(expected = InputException.class)
    public void testSignUpWithUsernameExist() throws InputException, IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setPhone("0987278371");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }

    //Test tạo user khi username null
    @Test(expected = Exception.class)
    public void testSignUpWithUsernameNull() throws  IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setPassword("admin");
        user.setPhone("0987278344");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }

    //Test tạo user khi password null
    @Test(expected = Exception.class)
    public void testSignUpWithPasswordNull() throws  IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("admin");
        user.setPhone("0987278333");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }
    //Test tạo user khi username nhỏ hơn 3 kí tự
    @Test(expected = InputException.class)
    public void testSignUpWithUsernameWrongFormat() throws IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("ad");
        user.setPassword("admin");
        user.setPhone("0987278356");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }
    //Test tạo user khi password lớn hơn 10 kí tự
    @Test(expected = Exception.class)
    public void testSignUpWithPasswordWrongFormat() throws LoginException, IOException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("nguyendinhvana");
        user.setUsername("adminadminadminadminadmin");
        user.setPhone("0987278333");
        user.setEmail("admin@gmail.com");
        userController.addUser(user);
    }


    // test email
    //Test tạo user khi email null
    @Test(expected = Exception.class)
    public void testSignUpWithEmailNull() throws IOException {
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("nguyenvanbinhd");
        user.setUsername("adminad");
        user.setPhone("0987278333");
        userController.addUser(user);
    }
    @Test(expected = InputException.class)
    public void testSignUpWithEmailWrong() throws IOException {
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("nguyenvanbinhd");
        user.setUsername("adminad");
        user.setPhone("0987278333");
        user.setEmail("binhagmail.com");
        userController.addUser(user);
    }


    // test email
    //Test tạo user khi email null
    @Test(expected = Exception.class)
    public void testSignUpWithPhoneNull() throws IOException {
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("nguyenvanbinhd");
        user.setUsername("adminad");
        user.setEmail("binhr@gmail.com");
        userController.addUser(user);
    }

    //Test tạo user khi phone sai format
    @Test(expected = InputException.class)
    public void testSignUpWithPhoneWrongFormat() throws IOException {
        AdminUserController userController = applicationContext.getBean(AdminUserController.class);
        UserDTORequest user = new UserDTORequest();
        user.setUsername("nguyenvanbinhd");
        user.setUsername("adminad");
        user.setPhone("09872783336666666");
        user.setEmail("binhr@gmail.com");
        userController.addUser(user);
    }

}
