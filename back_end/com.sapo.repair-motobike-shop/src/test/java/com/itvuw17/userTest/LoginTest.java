package com.itvuw17.userTest;

import com.sapo.StartWebApplication;
import com.sapo.controllers.LoginController;
import com.sapo.controllers.admin.AdminUserController;
import com.sapo.dto.sercurity.LoginForm;
import com.sapo.dto.users.UserDTORequest;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import javax.security.auth.login.LoginException;
import java.io.IOException;

//Các test case đăng nhập
@SpringBootTest
@DirtiesContext
public class LoginTest {
    static ApplicationContext applicationContext = SpringApplication.run(StartWebApplication.class);

    //Test login thành công
    @Test
    public void testLoginSuccess() throws LoginException {

        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("admin");
        loginController.authenticateUser(login);
        System.out.println(loginController.authenticateUser(login).getBody().toString());
    }

    //Test đăng nhập bằng sai username và password
    @Test(expected = Exception.class)
    public void testLoginWithUsernamePasswordWrong() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("admin12");
        loginController.authenticateUser(login);
    }
    //Test login với các ký tự đặc biệt ở username
    @Test(expected = LoginException.class)
    public void testLoginWithUsernameHasSpecialCharacters() throws LoginException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("Adm>?:");
        login.setPassword("admin");
        loginController.authenticateUser(login);
        System.out.println(loginController.authenticateUser(login));
    }

    //Test login với các ký tự đặc biệt ở password
    @Test(expected = LoginException.class)
    public void testLoginWithPasswordHasSpecialCharacters() throws LoginException {
        //    ApplicationContext context = SpringApplication.run(Application.class, args);
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("Adm>?:");
        loginController.authenticateUser(login);
        System.out.println(loginController.authenticateUser(login).getStatusCode());
    }

    //Test login với username null
    @Test(expected = LoginException.class)
    public void testLoginWithUsernameNull() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
//        login.setUsername("admin");
        login.setPassword("admin");
        loginController.authenticateUser(login);
    }

    //Test login với password null
    @Test(expected = LoginException.class)
    public void testLoginWithPasswordNull() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
//        login.setPassword("admin");
        loginController.authenticateUser(login);
    }


    //Test login với user dài hơn so với độ dài cho phép
    @Test(expected = LoginException.class)
    public void testLoginWithUserInvalid1() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("adminadminadminadminadminadmina");
        login.setPassword("admin");
        loginController.authenticateUser(login);
    }

    //Test login với user ngắn hơn so với độ dài cho phép
    @Test(expected = LoginException.class)
    public void testLoginWithUserInvalid2() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("ad");
        login.setPassword("admin");
        loginController.authenticateUser(login);
    }

    //Test login với password dài hơn so với độ dài cho phép
    @Test(expected = LoginException.class)
    public void testLoginWithPasswordInvalid1() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("adminadmina");
        loginController.authenticateUser(login);
    }

    //Test login với password ngắn hơn so với độ dài cho phép
    @Test(expected = LoginException.class)
    public void testLoginWithPasswordInvalid2() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("adm");
        loginController.authenticateUser(login);
    }

    //Test login bằng tấn công injection sql
    @Test(expected = LoginException.class)
    public void testLoginWithInjectionSql() throws LoginException {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        LoginForm login = new LoginForm();
        login.setUsername("john' OR 1=1; --");
        login.setPassword("123456");
        loginController.authenticateUser(login);
    }


}
