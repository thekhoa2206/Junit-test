package com.itvuw17.userTest;

import com.sapo.StartWebApplication;
import com.sapo.controllers.LoginController;
import com.sapo.dto.sercurity.LoginForm;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.security.auth.login.LoginException;

//Các test case đăng nhập
@SpringBootTest
public class LoginTest {
    ApplicationContext applicationContext = SpringApplication.run(StartWebApplication.class);
    LoginController loginController = applicationContext.getBean(LoginController.class);

    //Test login thành công
    @Test
    public void testLoginSuccess() throws LoginException {
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("admin");
        loginController.authenticateUser(login);
    }


    //Test login với các ký tự đặc biệt ở username
    @Test
    public void testLoginWithSpecialCharacters() throws LoginException {
        LoginForm login = new LoginForm();
        login.setUsername("Adm>?:");
        login.setPassword("admin");
        loginController.authenticateUser(login);
    }

    //Test login với username password null
    @Test
    public void testLoginWithLoginNull() throws LoginException {
        LoginForm login = new LoginForm();
        login.setUsername("admin");
//        login.setPassword("admin");
        loginController.authenticateUser(login);
    }

}
