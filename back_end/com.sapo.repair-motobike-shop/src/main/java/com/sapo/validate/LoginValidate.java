package com.sapo.validate;

import com.sapo.dto.sercurity.LoginForm;


import javax.security.auth.login.LoginException;

public class LoginValidate {

    public static void loginNotNull(LoginForm loginForm) throws LoginException {
        if(loginForm.getUsername() == null || loginForm.getUsername().isEmpty()){
            throw new LoginException("Tên đăng nhập không được để trống");
        }
        if(loginForm.getPassword() == null || loginForm.getPassword().isEmpty()){
            throw new LoginException("Mật khẩu không được để trống");
        }
    }

    public static void loginNotSpecialCharacters(LoginForm loginForm) throws LoginException {
        if(InputValidate.getSpecialCharacterCount(loginForm.getUsername()) == false){
            throw new LoginException("Tên đăng nhập không được có ký tự đặc biệt!");
        }
        if(InputValidate.getSpecialCharacterCount(loginForm.getPassword()) == false){
            throw new LoginException("Mật khẩu không được có ký tự đặc biệt!");
        }
    }
}
